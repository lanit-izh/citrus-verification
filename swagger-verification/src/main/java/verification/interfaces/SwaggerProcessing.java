package verification.interfaces;

import java.io.FileInputStream;

public interface SwaggerProcessing {

    public String deleteJsonDeprecatedEndpoints(String swagger);
    public String deleteYamlDeprecatedEndpoints(String swagger);
    public String deleteIncorrectEndpoints(String swagger);
    public String verificateJsonSwagger(String swagger);
}
