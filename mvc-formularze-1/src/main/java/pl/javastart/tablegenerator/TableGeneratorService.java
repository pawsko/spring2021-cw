package pl.javastart.tablegenerator;

import com.github.freva.asciitable.AsciiTable;

class TableGeneratorService {
    public static final String DATA_SEPARATOR = ";";

    public static String getTextTable(String[] headers, String[][] data) {
        return AsciiTable.getTable(headers, data);
    }
}
