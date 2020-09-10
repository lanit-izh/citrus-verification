package verification.reader;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileSwaggerReader {

    private File file;

    public FileSwaggerReader(File file) {
        this.file = file;
    }

    public String readFile() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return getContentFile(fileInputStream);
    }

    private String getContentFile(FileInputStream fis) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(Files.newBufferedReader(file.toPath(), StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
