package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {
        String content1 = readFile(filepath1);
        String content2 = readFile(filepath2);
        String format1 = getFormat(filepath1);
        String format2 = getFormat(filepath2);
        Map<String, Object> data1 = Parser.getData(content1, format1);
        Map<String, Object> data2 = Parser.getData(content2, format2);
        List<DiffEntry> differences = DiffCalculator.calculate(data1, data2);
        return Formatter.format(differences, formatName);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    private static String readFile(String path) throws IOException {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new IOException("File '" + path + "' does not exist");
        }
        return Files.readString(filePath);
    }

    private static String getFormat(String path) {
        int lastDotIndex = path.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        String extension = path.substring(lastDotIndex + 1);
        return switch (extension) {
            case "json" -> "json";
            case "yaml", "yml" -> "yaml";
            default -> throw new IllegalArgumentException("Unsupported file extension: " + extension);
        };
    }
}
