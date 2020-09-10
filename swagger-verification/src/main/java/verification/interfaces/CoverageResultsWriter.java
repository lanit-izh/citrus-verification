package verification.interfaces;

import freemarker.template.TemplateException;
import verification.results.Results;

import java.io.IOException;

public interface CoverageResultsWriter {

    void write(Results results) throws IOException, TemplateException;
}
