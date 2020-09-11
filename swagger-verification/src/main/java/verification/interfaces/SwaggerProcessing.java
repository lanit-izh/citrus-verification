package verification.interfaces;

public interface SwaggerProcessing {

    String deleteJsonDeprecatedEndpoints(String swagger);

    String deleteYamlDeprecatedEndpoints(String swagger);

    String deleteIncorrectEndpoints(String swagger, boolean isDelete);

    String verifyJsonSwagger(String swagger, boolean isDelete);
}
