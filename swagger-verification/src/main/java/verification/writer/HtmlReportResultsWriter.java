package verification.writer;

import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import verification.interfaces.CoverageResultsWriter;
import verification.results.Results;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static verification.utils.FreemarkerUtils.processTemplate;

public class HtmlReportResultsWriter implements CoverageResultsWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlReportResultsWriter.class);

    private String filename = "verification-report.html";

    public HtmlReportResultsWriter() {
    }

    @Override
    public void write(Results results) throws IOException, TemplateException {
        Path path = Paths.get(filename);
        LOGGER.info(String.format("Write html report in file '%s'", path.toAbsolutePath()));
        final String htmlReport = processTemplate(results);
        Files.write(Paths.get(filename), htmlReport.getBytes());
    }
}
