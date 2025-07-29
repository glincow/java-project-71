package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {
        Map<String, Object> data1 = Parser.getData(filepath1);
        Map<String, Object> data2 = Parser.getData(filepath2);
        List<DiffEntry> differences = DiffCalculator.calculate(data1, data2);
        return Formatter.format(differences, formatName);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        Map<String, Object> data1 = Parser.getData(filepath1);
        Map<String, Object> data2 = Parser.getData(filepath2);
        List<DiffEntry> differences = DiffCalculator.calculate(data1, data2);
        return Formatter.format(differences, "stylish");
    }
}
