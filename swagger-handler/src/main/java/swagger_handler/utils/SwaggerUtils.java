package swagger_handler.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import swagger_handler.interfaces.SwaggerProcessable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SwaggerUtils implements SwaggerProcessable {

    @Override
    public String getContentFile(FileInputStream fis) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public String deleteIncorrectEndpoints(String swagger) {
        boolean incorrectEndpoint = false;
        List<String> parametersEndpoint;
        List<String> bodyParams = new ArrayList<>();
        Object o = null;
        List<String> parameters = new ArrayList<>();
        List<Map.Entry<String, JsonNode>> incorrectEndpoints = new ArrayList<>();
        JsonNode actualObj = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            actualObj = mapper.readTree(swagger);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Iterator<Map.Entry<String, JsonNode>> iterator = actualObj.get("paths").fields();
        while (iterator.hasNext()) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            parametersEndpoint = Stream.of(entry.getKey().split("/"))
                    .filter(x -> x.startsWith("{") && x.endsWith("}"))
                    .map(x -> x.replace("{", "").replace("}", ""))
                    .collect(Collectors.toList());

            Stream.of(entry.getValue()).filter(x -> x.get("get") != null)
                    .filter(x -> x.get("get").get("parameters") != null)
                    .map(x -> x.get("get").get("parameters")).collect(Collectors.toList())
                    .forEach(x -> x.forEach(b -> {

                        if ((b.get("in").textValue().equals("path"))) {
                            parameters.add(b.get("name").textValue());
                        }
                    }));

            if (!(parameters.equals(parametersEndpoint))) {
                if (entry.getValue().get("get") != null) {
                    incorrectEndpoint = true;
                }
            }
            parameters.clear();

            Stream.of(entry.getValue()).filter(x -> x.get("post") != null)
                    .filter(x -> x.get("post").get("parameters") != null)
                    .map(x -> x.get("post").get("parameters")).collect(Collectors.toList())
                    .forEach(x -> x.forEach(b -> {
                        if ((b.get("in").textValue().equals("path"))) {
                            parameters.add(b.get("name").textValue());
                        }
                        if ((b.get("in").textValue().equals("body"))) {
                            bodyParams.add(b.get("name").textValue());
                        }
                    }));

            if (parameters.equals(parametersEndpoint) && bodyParams.size() == 0) {
                if (entry.getValue().get("post") != null) {
                        incorrectEndpoint = true;
                }
            }
                bodyParams.clear();
                parameters.clear();

                Stream.of(entry.getValue()).filter(x -> x.get("put") != null)
                        .filter(x -> x.get("put").get("parameters") != null)
                        .map(x -> x.get("put").get("parameters")).collect(Collectors.toList())
                        .forEach(x -> x.forEach(b -> {
                            if ((b.get("in").textValue().equals("path"))) {
                                parameters.add(b.get("name").textValue());
                            }
                        }));

                if (!(parameters.equals(parametersEndpoint))) {
                    if (entry.getValue().get("put") != null) {
                        incorrectEndpoint = true;
                    }
                }
                parameters.clear();

                Stream.of(entry.getValue()).filter(x -> x.get("delete") != null)
                        .filter(x -> x.get("delete").get("parameters") != null)
                        .map(x -> x.get("delete").get("parameters")).collect(Collectors.toList())
                        .forEach(x -> x.forEach(b -> {
                            if ((b.get("in").textValue().equals("path"))) {
                                parameters.add(b.get("name").textValue());
                            }
                        }));

                if (!(parameters.equals(parametersEndpoint))) {
                    if (entry.getValue().get("delete") != null) {
                        incorrectEndpoint = true;
                    }
                }
                parameters.clear();

                if (incorrectEndpoint) {
                    incorrectEndpoints.add(entry);
                    iterator.remove();
                }
                incorrectEndpoint = false;
                parameters.clear();
                parametersEndpoint.clear();
            }
            return actualObj.toString();
        }

        @Override
        public String deleteJsonDeprecatedEndpoints (String swagger){
            JsonNode actualObj = null;
            ObjectMapper mapper = new ObjectMapper();
            try {
                actualObj = mapper.readTree(swagger);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Iterator<Map.Entry<String, JsonNode>> iterator = actualObj.get("paths").fields();
            while (iterator.hasNext()) {
                if ((iterator.next().getValue().fields().next().getValue().get("deprecated") != null)) {
                    iterator.remove();
                }
            }
            return actualObj.toString();
        }

        @Override
        public String deleteYamlDeprecatedEndpoints (String swagger){
            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            ObjectMapper jsonWriter = new ObjectMapper();
            Object object;
            String json = "";
            JsonNode jsonNode;
            String yaml = "";
            String processedJson;
            try {
                object = yamlMapper.readValue(swagger, Object.class);
                json = jsonWriter.writerWithDefaultPrettyPrinter().writeValueAsString(object);
            } catch (IOException e) {
                e.printStackTrace();
            }
            processedJson = deleteJsonDeprecatedEndpoints(json);

            try {
                jsonNode = yamlMapper.readTree(processedJson);
                yaml = new YAMLMapper().writeValueAsString(jsonNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return yaml;
        }

        @Override
        public String cleanJsonSwagger (String swagger){
            return deleteJsonDeprecatedEndpoints(deleteIncorrectEndpoints(swagger));
        }
    }
