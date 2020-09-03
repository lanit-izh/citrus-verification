package verification;

import com.github.bjansen.ssv.SwaggerValidator;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//todo to modify this class
public class ValidateSwagger {

    private String path;
    public void validateJson()  {
        BufferedReader spec = null;
        SwaggerValidator validator = null;
        try {
            spec = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            validator = SwaggerValidator.forJsonSchema(spec);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
          validator.validate("{\"name\": \"Bob\"}", "/api/clients/{clientId}/configs");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ProcessingException e) {
            e.printStackTrace();
        }
    }
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
