//package verification;
//
//import freemarker.template.TemplateException;
//import verification.core.Swagger2Verification;
//import verification.reader.FileSwaggerReader;
//import verification.results.Results;
//import verification.writer.FileSwaggerWriter;
//import verification.writer.HtmlReportResultsWriter;
//
//import java.io.File;
//import java.io.IOException;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException, TemplateException {
//        HtmlReportResultsWriter htmlReportResultsWriter = new HtmlReportResultsWriter();
//        Swagger2Verification swagger2Verification = new Swagger2Verification();
//        File file = new File("src/main/resources/api-docs.json");
//        FileSwaggerReader fileSystemReader;
//        fileSystemReader = new FileSwaggerReader(file);
//        FileSwaggerWriter fileWriter = new FileSwaggerWriter(file);
//        fileWriter.write(swagger2Verification.verifyJsonSwagger(fileSystemReader.readFile(), false));
//        Results results = new Results.Builder().setDeleteIncorrectEndpoints(swagger2Verification.getDeleteIncorrectEndpoints())
//                .setPostIncorrectEndpoints(swagger2Verification.getPostIncorrectEndpoints())
//                .setPutIncorrectEndpoints(swagger2Verification.getPutIncorrectEndpoints())
//                .setGetIncorrectEndpoints(swagger2Verification.getGetIncorrectEndpoints()).build();
//        htmlReportResultsWriter.write(results);
//    }
//}
