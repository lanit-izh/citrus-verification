package verification.utils;

import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.models.Swagger;

import java.util.List;
import java.util.Map;

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

        return new Swagger();
    }
}
