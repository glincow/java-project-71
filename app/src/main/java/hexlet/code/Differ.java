package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(Map<String, Object> file1,
                                  Map<String, Object> file2,
                                  String formatName) throws Exception {
        List<DiffEntry> differences = DiffCalculator.calculate(file1, file2);
        return Formatter.format(differences, formatName);
    }
}
