package hexlet.code;

import java.util.List;
import java.util.Map;

public class Differ {
    public static String generate(Map<String, String> file1,
                                  Map<String, String> file2,
                                  String format) throws Exception {
        List<DiffEntry> differences = DiffCalculator.calculate(file1, file2);
        return switch (format) {
            case "stylish" -> formatDiff(differences);
            default -> throw new Exception("This format is not supported");
        };
    }

    private static String formatDiff(List<DiffEntry> differences) {
        StringBuilder result = new StringBuilder();
        result.append("\n{\n");

        for (DiffEntry entry : differences) {
            switch (entry.getType()) {
                case ADDED:
                    result.append("  + ").append(entry.getKey())
                            .append(": ").append(entry.getNewValue()).append("\n");
                    break;
                case DELETED:
                    result.append("  - ").append(entry.getKey())
                            .append(": ").append(entry.getOldValue()).append("\n");
                    break;
                case CHANGED:
                    result.append("  - ").append(entry.getKey())
                            .append(": ").append(entry.getOldValue()).append("\n");
                    result.append("  + ").append(entry.getKey())
                            .append(": ").append(entry.getNewValue()).append("\n");
                    break;
                case UNCHANGED:
                    result.append("    ").append(entry.getKey())
                            .append(": ").append(entry.getOldValue()).append("\n");
                    break;
                default:
                    break;
            }
        }

        result.append("}");
        return result.toString();
    }
}
