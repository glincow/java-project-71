package hexlet.code.formatters;

import hexlet.code.DiffEntry;

import java.util.List;

public class StylishFormatter {
    public static String format(List<DiffEntry> differences) {
        StringBuilder result = new StringBuilder("{\n");

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
