package verification.interfaces;

public interface SwaggerProcessing {

    public String deleteJsonDeprecatedEndpoints(String swagger);
    public String deleteYamlDeprecatedEndpoints(String swagger);
    public String deleteIncorrectEndpoints(String swagger);
    public String verifyJsonSwagger(String swagger);
}
