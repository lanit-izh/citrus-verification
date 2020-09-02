package swagger_handler;

import swagger_handler.utils.SwaggerUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main (String[] args){
        FileInputStream fileInputStream = null;
        SwaggerUtils swaggerUtils =  new SwaggerUtils();
        try {
             fileInputStream = new FileInputStream("D:\\Work\\swagger_handler\\swagger-handler\\src\\main\\resources\\api-docs.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        swaggerUtils.cleanJsonSwagger(swaggerUtils.getContentFile(fileInputStream));
    }
}
