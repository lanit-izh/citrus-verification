package verification.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileSwaggerWriter {

    private final File file;

    public FileSwaggerWriter(File file) {
        this.file = file;
    }
    public void write(String swagger) throws IOException {

        try (FileWriter fw = new FileWriter(file.getName())) {

            fw.write(swagger);
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
