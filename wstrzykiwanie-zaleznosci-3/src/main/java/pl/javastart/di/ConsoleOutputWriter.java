package pl.javastart.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.javastart.di.formatter.TextFormatter;

@Service
class ConsoleOutputWriter {

    private final TextFormatter textFormatter;

    @Autowired
    ConsoleOutputWriter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    void println(String text) {
        String formattedText = textFormatter.format(text);
        System.out.println(formattedText);
    }

}
