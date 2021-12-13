package pl.javastart.di.formatter;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
class UpperCaseFormatter implements TextFormatter {
    @Override
    public String format(String originalText) {
        return originalText.toUpperCase();
    }
}
