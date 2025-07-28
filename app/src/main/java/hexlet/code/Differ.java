package hexlet.code;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(Map<String, String> file1, Map<String, String> file2) {
        StringBuilder result = new StringBuilder();
        Set<String> keys = new TreeSet<>(file1.keySet());
        keys.addAll(file2.keySet());

        result.append("\n{\n");
        for (String key : keys) {
            Object value1 = file1.getOrDefault(key, null);
            Object value2 = file2.getOrDefault(key, null);

            if (value1 == null) {
                result.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else if (value2 == null) {
                result.append("  - ").append(key).append(": ").append(value1).append("\n");
            } else if (!value1.equals(value2)) {
                result.append("  - ").append(key).append(": ").append(value1).append("\n");
                result.append("  + ").append(key).append(": ").append(value2).append("\n");
            } else {
                result.append("    ").append(key).append(": ").append(value1).append("\n");
            }
        }
        result.append("}");

        return result.toString();
    }
}
