package swagger_handler.utils;

import swagger_handler.interfaces.SwaggerProcessing;

import java.io.FileInputStream;

public class AbstractSwaggerVerification implements SwaggerProcessing {
    @Override
    public String deleteJsonDeprecatedEndpoints(String swagger) {
        return null;
    }

    @Override
    public String deleteYamlDeprecatedEndpoints(String swagger) {
        return null;
    }

    @Override
    public String getContentFile(FileInputStream fis) {
        return null;
    }

    @Override
    public String deleteIncorrectEndpoints(String swagger) {
        return null;
    }

    @Override
    public String verificateJsonSwagger(String swagger) {
        return null;
    }
}
