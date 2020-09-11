package verification.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import verification.results.Results;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public final class FreemarkerUtils {

    private static final Logger log = LoggerFactory.getLogger(FreemarkerUtils.class);

    private FreemarkerUtils() {
    }

    public static String processTemplate(Results results) throws IOException, TemplateException {

        final Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassForTemplateLoading(FreemarkerUtils.class, "/");
        configuration.setDefaultEncoding("UTF-8");
        Map<String, Object> root = new HashMap<>();
        root.put("results", results);
        Template template = configuration.getTemplate("report.ftl");
        final Writer writer = new StringWriter();
        template.process(root, writer);
        return writer.toString();
    }
}
