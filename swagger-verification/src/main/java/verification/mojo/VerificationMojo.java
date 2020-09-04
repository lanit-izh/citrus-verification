package verification.mojo;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import verification.Swagger2Verification;
import verification.utils.FileSwaggerReader;
import verification.utils.FileSwaggerWriter;

import java.io.File;
import java.io.IOException;


@Mojo(name = "setPath", defaultPhase = LifecyclePhase.PROCESS_CLASSES, threadSafe = true)
public class VerificationMojo extends AbstractMojo {
    @Parameter(property =  "path")
    private String path;

//    @Parameter( defaultValue = "${project}", readonly = true )
//    private MavenProject project;

    public void execute() throws MojoExecutionException {
        File file = new File(path);
        FileSwaggerReader fileSystemReader;
        fileSystemReader = new FileSwaggerReader(file);
        FileSwaggerWriter fileWriter = new FileSwaggerWriter(file);

        try {
            fileWriter.write(new Swagger2Verification().verifyJsonSwagger(fileSystemReader.readFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}