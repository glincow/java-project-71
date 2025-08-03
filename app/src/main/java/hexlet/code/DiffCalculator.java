package hexlet.code;

import java.util.Objects;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map;
import java.util.ArrayList;

public class DiffCalculator {
    public static List<DiffEntry> calculate(Map<String, Object> file1, Map<String, Object> file2) {
        List<DiffEntry> differences = new ArrayList<>();
        Set<String> keys = new TreeSet<>(file1.keySet());
        keys.addAll(file2.keySet());

        for (String key : keys) {
            Object value1 = file1.get(key);
            Object value2 = file2.get(key);

            if (!file1.containsKey(key)) {
                differences.add(new DiffEntry(key, null, value2, DiffEntry.DiffType.ADDED));
            } else if (!file2.containsKey(key)) {
                differences.add(new DiffEntry(key, value1, null, DiffEntry.DiffType.DELETED));
            } else if (!Objects.equals(value1, value2)) {
                differences.add(new DiffEntry(key, value1, value2, DiffEntry.DiffType.CHANGED));
            } else {
                differences.add(new DiffEntry(key, value1, value2, DiffEntry.DiffType.UNCHANGED));
            }
        }

        return differences;
    }
}
