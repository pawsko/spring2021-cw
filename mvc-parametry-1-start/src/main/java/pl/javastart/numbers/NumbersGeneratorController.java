package pl.javastart.numbers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class NumbersGeneratorController {

    private final NumberService numberService;

    public NumbersGeneratorController(NumberService numberService) {
        this.numberService = numberService;
    }

    @GetMapping("/random")
    @ResponseBody
    String getRandomNumber() {
        return null;
    }

    @GetMapping("/even-numbers")
    @ResponseBody
    String getEvenNumbers() {
        return null;
    }

    @GetMapping("/odd-numbers")
    @ResponseBody
    String getOddNumbers() {
        return null;
    }
}
