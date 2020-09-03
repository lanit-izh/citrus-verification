package verification.utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

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
