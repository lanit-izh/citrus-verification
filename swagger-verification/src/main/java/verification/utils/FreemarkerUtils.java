package verification.utils;

import com.fasterxml.jackson.databind.JsonNode;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class FreemarkerUtils {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerUtils.class);

    private final static String TEMPLATES = "templates";

    private FreemarkerUtils() {
    }

    public static String processTemplate(final String path, final Object object) {
        return processTemplate(path, "en", object);
    }

    public static String processTemplate(final String path, String locale, final Object object) {
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);

        configuration.setClassForTemplateLoading(FreemarkerUtils.class, "/");
        configuration.setDefaultEncoding("UTF-8");

        try {
            final Map<String, Object> data = new HashMap<>();
            data.put("data", object);

            final Writer writer = new StringWriter();
            final Template template = configuration.getTemplate(path);
            template.process(data, writer);
            return writer.toString();
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public static String processTemplate(List<Map.Entry<String, JsonNode>> incorrectEndpoints) throws IOException, TemplateException {
        File file = new File("src\\main\\resources\\templates");
        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setDirectoryForTemplateLoading(file);
        configuration.setDefaultEncoding("UTF-8");
        List<String> endpoints = incorrectEndpoints.stream().map(x -> x.getKey()).collect(Collectors.toList());
        Map<String, Object> root = new HashMap<>();
        root.put("endpoints", endpoints);
        Template template = configuration.getTemplate("example.ftl");
        Writer writer = new OutputStreamWriter(System.out);
        template.process(root, writer);
        writer.toString();
        return writer.toString();
    }
}
