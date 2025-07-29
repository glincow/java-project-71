package hexlet.code;

import hexlet.code.formatters.PlainFormatter;
import hexlet.code.formatters.StylishFormatter;

import java.util.List;

public class Formatter {
    public static String format(List<DiffEntry> differences, String formatName) throws Exception {
        return switch (formatName) {
            case "stylish" -> StylishFormatter.format(differences);
            case "plain" -> PlainFormatter.format(differences);
            default -> throw new Exception("This format is not supported");
        };
    }
}
