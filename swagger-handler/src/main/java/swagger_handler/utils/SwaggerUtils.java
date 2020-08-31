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
import java.util.Iterator;
import java.util.Map;

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
}
