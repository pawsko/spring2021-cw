package pl.javastart.codeformatter;

import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Service;

@Service
class CodeFormatterService {

    String formatCode(String source) throws FormatterException {
        return new Formatter().formatSource(source);
    }
}
