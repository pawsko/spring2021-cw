package pl.javastart.tablegenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class TableController {

    //@PostMapping(path = "/generate", produces = "text/plain")
    @PostMapping("/generate")
    @ResponseBody
    String generateTable(@RequestParam String headers, @RequestParam String data) {
        String[] headersArray = headers.split(TableGeneratorService.DATA_SEPARATOR);
        String[] dataRows = data.split("\n");
        String[][] dataArray = new String[dataRows.length][];
        for (int i = 0; i < dataRows.length; i++) {
            dataArray[i] = dataRows[i].split(TableGeneratorService.DATA_SEPARATOR);
        }
        return "<pre>" + TableGeneratorService.getTextTable(headersArray, dataArray) + "</pre>";
    }
}
