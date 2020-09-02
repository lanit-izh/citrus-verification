package swagger_handler.interfaces;

import java.io.FileInputStream;

public interface SwaggerProcessable {

    public String deleteJsonDeprecatedEndpoints(String swagger);
    public String deleteYamlDeprecatedEndpoints(String swagger);
    public String getContentFile(FileInputStream fis);
    public String deleteIncorrectEndpoints(String swagger);
    public String cleanJsonSwagger(String swagger);
}
