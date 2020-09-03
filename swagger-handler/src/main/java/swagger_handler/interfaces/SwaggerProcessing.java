package swagger_handler.interfaces;

import java.io.FileInputStream;

public interface SwaggerProcessing {

    public String deleteJsonDeprecatedEndpoints(String swagger);
    public String deleteYamlDeprecatedEndpoints(String swagger);
    public String getContentFile(FileInputStream fis);
    public String deleteIncorrectEndpoints(String swagger);
    public String verificateJsonSwagger(String swagger);
}
