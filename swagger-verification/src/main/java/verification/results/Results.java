package verification.results;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;
import java.util.Map;

public class Results {
    private List<Map.Entry<String, JsonNode>> incorrectEndpoints;
    private List<Map.Entry<String, JsonNode>> postIncorrectEndpoints;
    private List<Map.Entry<String, JsonNode>> putIncorrectEndpoints;
    private List<Map.Entry<String, JsonNode>> getIncorrectEndpoints;
    private List<Map.Entry<String, JsonNode>> deleteIncorrectEndpoints;

    public List<Map.Entry<String, JsonNode>> getIncorrectEndpoints() {
        return incorrectEndpoints;
    }

    public List<Map.Entry<String, JsonNode>> getPostIncorrectEndpoints() {
        return postIncorrectEndpoints;
    }

    public List<Map.Entry<String, JsonNode>> getPutIncorrectEndpoints() {
        return putIncorrectEndpoints;
    }

    public List<Map.Entry<String, JsonNode>> getGetIncorrectEndpoints() {
        return getIncorrectEndpoints;
    }

    public List<Map.Entry<String, JsonNode>> getDeleteIncorrectEndpoints() {
        return deleteIncorrectEndpoints;
    }

    public int amountEndpoints() {
        return getIncorrectEndpoints.size() + putIncorrectEndpoints.size() + deleteIncorrectEndpoints.size();
    }

    public static class Builder {
        private Results results;

        public Builder() {
            results = new Results();
        }

        public Builder setIncorrectEndpoints(List<Map.Entry<String, JsonNode>> incorrectEndpoints) {
            this.results.incorrectEndpoints = incorrectEndpoints;
            return this;
        }

        public Builder setPostIncorrectEndpoints(List<Map.Entry<String, JsonNode>> postIncorrectEndpoints) {
            this.results.postIncorrectEndpoints = postIncorrectEndpoints;
            return this;
        }

        public Builder setPutIncorrectEndpoints(List<Map.Entry<String, JsonNode>> putIncorrectEndpoints) {
            this.results.putIncorrectEndpoints = putIncorrectEndpoints;
            return this;
        }

        public Builder setGetIncorrectEndpoints(List<Map.Entry<String, JsonNode>> getIncorrectEndpoints) {
            this.results.getIncorrectEndpoints = getIncorrectEndpoints;
            return this;
        }

        public Builder setDeleteIncorrectEndpoints(List<Map.Entry<String, JsonNode>> deleteIncorrectEndpoints) {
            this.results.deleteIncorrectEndpoints = deleteIncorrectEndpoints;
            return this;
        }

        public Results build() {
            return results;
        }
    }
}
