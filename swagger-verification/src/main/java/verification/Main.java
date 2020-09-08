package verification;

import freemarker.template.TemplateException;
import verification.utils.FreemarkerUtils;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException, TemplateException {
        Swagger2Verification swagger2Verification = new Swagger2Verification();
        File file = new File("src/main/resources/api-docs.json");
        FileSwaggerReader fileSystemReader;
        fileSystemReader = new FileSwaggerReader(file);
        FileSwaggerWriter fileWriter = new FileSwaggerWriter(file);
        fileWriter.write(swagger2Verification.verifyJsonSwagger(fileSystemReader.readFile()));

        try {
            FreemarkerUtils.processTemplate(swagger2Verification.getIncorrectEndpoints());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
