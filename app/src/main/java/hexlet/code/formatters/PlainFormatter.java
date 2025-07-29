package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.List;
import java.util.Collection;
import java.util.Map;

public class PlainFormatter {
    public static String format(List<DiffEntry> differences) {
        StringBuilder result = new StringBuilder();

        for (DiffEntry entry : differences) {
            switch (entry.getType()) {
                case ADDED:
                    result.append("Property '").append(entry.getKey())
                            .append("' was added with value: ")
                            .append(formatValue(entry.getNewValue()))
                            .append("\n");
                    break;
                case DELETED:
                    result.append("Property '").append(entry.getKey())
                            .append("' was removed\n");
                    break;
                case CHANGED:
                    result.append("Property '").append(entry.getKey())
                            .append("' was updated. From ")
                            .append(formatValue(entry.getOldValue()))
                            .append(" to ")
                            .append(formatValue(entry.getNewValue()))
                            .append("\n");
                    break;
                case UNCHANGED:
                    break;
                default:
                    break;
            }
        }

        return result.toString().trim();
    }

    private static String formatValue(Object value) {
        if (value == null) {
            return "null";
        }

        if (value instanceof String) {
            return "'" + value + "'";
        }

        if (value instanceof Collection || value instanceof Map || value.toString().contains("{")) {
            return "[complex value]";
        }

        return value.toString();
    }
}
