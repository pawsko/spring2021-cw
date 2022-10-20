package pl.javastart.di;

import org.springframework.stereotype.Service;
import pl.javastart.di.formatter.TextFormatter;

@Service
public class ConsoleOutputWriter {
    private final TextFormatter textFormatter;

    public ConsoleOutputWriter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    void println(String text){
        String formattedText = textFormatter.format(text);
        System.out.println(formattedText);
    }
}
