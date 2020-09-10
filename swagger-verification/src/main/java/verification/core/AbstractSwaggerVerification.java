package verification.core;

import com.fasterxml.jackson.databind.JsonNode;
import verification.interfaces.SwaggerProcessing;

import java.util.List;
import java.util.Map;

public abstract class AbstractSwaggerVerification implements SwaggerProcessing {

    public abstract List<Map.Entry<String, JsonNode>> getPostIncorrectEndpoints();

    public abstract List<Map.Entry<String, JsonNode>> getPutIncorrectEndpoints();

    public abstract List<Map.Entry<String, JsonNode>> getGetIncorrectEndpoints();

    public abstract List<Map.Entry<String, JsonNode>> getDeleteIncorrectEndpoints();
}
