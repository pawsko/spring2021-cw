package pl.javastart.codeformatter;

import com.google.googlejavaformat.java.FormatterException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class CodeFormatterController {
    private final CodeFormatterService codeFormatterService;

    public CodeFormatterController(CodeFormatterService codeFormatterService) {
        this.codeFormatterService = codeFormatterService;
    }

    @GetMapping("/")
    String home() {
        return "index";
    }

    @PostMapping("/format")
    String formatCode(@RequestParam String code, Model model) {
        try {
            String formattedCode = codeFormatterService.formatCode(code);
            model.addAttribute("formattedCode", formattedCode);
        } catch (FormatterException e) {
            return "wrong-code";
        }
        model.addAttribute("unformattedCode", code);
        return "code-result";
    }
}
