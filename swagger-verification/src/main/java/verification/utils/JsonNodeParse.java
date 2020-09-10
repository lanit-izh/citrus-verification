package verification.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.collections.MappingChange;
import io.swagger.models.Operation;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.models.parameters.Parameter;
import io.swagger.parser.SwaggerParser;
import org.jvnet.hk2.internal.Collector;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsonNodeParse {

    static public Swagger parse(List<Map.Entry<String, JsonNode>>... listsJsonNode) {
//        Path path =  new Path();
//        Map.Entry<String, JsonNode>  s =  listsJsonNode[0].get(0);
//   Map aa = new HashMap<>();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            path =  objectMapper.readValue(s.getValue().toString(), Path.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String swagger = Arrays.asList(listsJsonNode).stream().map(x-> {
//            try {
//                return objectMapper.writeValueAsString(x);
//            } catch (JsonProcessingException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }).collect(Collectors.joining());

        return  new Swagger();
    }
    }
