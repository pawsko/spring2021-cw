package pl.javastart.time;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
class TimeController {

    @GetMapping("/current-year")
    @ResponseBody
    String currentYear() {
        return Integer.toString(LocalDate.now().getYear());
    }

    @GetMapping("/current-time")
    @ResponseBody
    String currentDate() {
        final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(timeFormatter);
    }
}
