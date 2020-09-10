package verification.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Swagger2Verification extends AbstractSwaggerVerification {

    private static Logger log = Logger.getLogger(Swagger2Verification.class.getName());

    private List<Map.Entry<String, JsonNode>> incorrectEndpoints = new ArrayList<>();
    private List<Map.Entry<String, JsonNode>> postIncorrectEndpoints = new ArrayList<>();
    private List<Map.Entry<String, JsonNode>> putIncorrectEndpoints = new ArrayList<>();
    private List<Map.Entry<String, JsonNode>> getIncorrectEndpoints = new ArrayList<>();
    private List<Map.Entry<String, JsonNode>> deleteIncorrectEndpoints = new ArrayList<>();
    private List<String> parametersEndpoint;
    private List<String> bodyParams = new ArrayList<>();
    private List<String> parameters = new ArrayList<>();

    @Override
    public String deleteIncorrectEndpoints(String swagger) {

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

            if (checkGetEndpoint(entry) || checkPostEndpoint(entry) || checkPutEndpoint(entry) || checkDeleteEndpoint(entry)) {
                incorrectEndpoints.add(entry);

             //   iterator.remove();
            }
        }


        getIncorrectEndpoints.forEach(x -> log.info("GET----> " + x.getKey()));
        postIncorrectEndpoints.forEach(x -> log.info("POST----> " + x.getKey()));
        putIncorrectEndpoints.forEach(x -> log.info("PUT----> " + x.getKey()));
        deleteIncorrectEndpoints.forEach(x -> log.info("DELETE----> " + x.getKey()));
        return actualObj.toString();
    }

    private boolean checkGetEndpoint(Map.Entry<String, JsonNode> entry) {
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
                getIncorrectEndpoints.add(entry);
                parameters.clear();
                return true;
            }
        }
        parameters.clear();
        return false;
    }

    private boolean checkPostEndpoint(Map.Entry<String, JsonNode> entry) {
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
                postIncorrectEndpoints.add(entry);
                bodyParams.clear();
                parameters.clear();
                return true;
            }
        }
        bodyParams.clear();
        parameters.clear();
        return false;
    }

    private boolean checkPutEndpoint(Map.Entry<String, JsonNode> entry) {
        Stream.of(entry.getValue()).filter(x -> x.get("put") != null)
                .filter(x -> x.get("put").get("parameters") != null)
                .map(x -> x.get("put").get("parameters")).collect(Collectors.toList())
                .forEach(x -> x.forEach(b -> {
                    if ((b.get("in").textValue().equals("path"))) {
                        parameters.add(b.get("name").textValue());
                    }
                    if ((b.get("in").textValue().equals("body"))) {
                        bodyParams.add(b.get("name").textValue());
                    }
                }));

        if (parameters.equals(parametersEndpoint) && bodyParams.size() == 0) {
            if (entry.getValue().get("put") != null) {
                putIncorrectEndpoints.add(entry);
                bodyParams.clear();
                parameters.clear();
                return true;
            }
        }
        bodyParams.clear();
        parameters.clear();
        return false;
    }

    private boolean checkDeleteEndpoint(Map.Entry<String, JsonNode> entry) {
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
                deleteIncorrectEndpoints.add(entry);
                parameters.clear();
                return true;
            }
        }
        parameters.clear();
        return false;
    }

    @Override
    public String deleteJsonDeprecatedEndpoints(String swagger) {
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
    public String deleteYamlDeprecatedEndpoints(String swagger) {
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

    public List<Map.Entry<String, JsonNode>> getIncorrectEndpoints() {
        return incorrectEndpoints;
    }

    @Override
    public String verifyJsonSwagger(String swagger) {
        return deleteJsonDeprecatedEndpoints(deleteIncorrectEndpoints(swagger));
    }

    @Override
    public List<Map.Entry<String, JsonNode>> getPostIncorrectEndpoints() {
        return postIncorrectEndpoints;
    }

    @Override
    public List<Map.Entry<String, JsonNode>> getPutIncorrectEndpoints() {
        return putIncorrectEndpoints;
    }

    @Override
    public List<Map.Entry<String, JsonNode>> getGetIncorrectEndpoints() {
        return getIncorrectEndpoints;
    }

    @Override
    public List<Map.Entry<String, JsonNode>> getDeleteIncorrectEndpoints() {
        return deleteIncorrectEndpoints;
    }
}
