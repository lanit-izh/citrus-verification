package verification.mojo;

import freemarker.template.TemplateException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import verification.core.Swagger2Verification;
import verification.reader.FileSwaggerReader;
import verification.results.Results;
import verification.writer.FileSwaggerWriter;
import verification.writer.HtmlReportResultsWriter;

import java.io.File;
import java.io.IOException;

@Mojo(name = "properties", defaultPhase = LifecyclePhase.PROCESS_CLASSES, threadSafe = true)
public class VerificationMojo extends AbstractMojo {
    @Parameter(property = "path")
    private String path;

    @Parameter(property = "isDelete")
    private boolean isDelete;

    public void execute() {
        Swagger2Verification swagger2Verification = new Swagger2Verification();
        File file = new File(path);
        FileSwaggerReader fileSystemReader;
        fileSystemReader = new FileSwaggerReader(file);
        FileSwaggerWriter fileWriter = new FileSwaggerWriter(file);
        fileWriter.write(swagger2Verification.verifyJsonSwagger(fileSystemReader.readFile(), isDelete));

        Results results = new Results.Builder()
                .setDeleteIncorrectEndpoints(swagger2Verification.getDeleteIncorrectEndpoints())
                .setPostIncorrectEndpoints(swagger2Verification.getPostIncorrectEndpoints())
                .setPutIncorrectEndpoints(swagger2Verification.getPutIncorrectEndpoints())
                .setGetIncorrectEndpoints(swagger2Verification.getGetIncorrectEndpoints()).build();
        try {
            new HtmlReportResultsWriter().write(results);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
