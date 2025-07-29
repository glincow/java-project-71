package hexlet.code;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class DiffEntry {
    private final String key;
    private final Object oldValue;
    private final Object newValue;
    private final DiffType type;

    public enum DiffType {
        ADDED,
        DELETED,
        CHANGED,
        UNCHANGED
    }

    public DiffEntry(String key, Object oldValue, Object newValue, DiffType type) {
        this.key = key;
        this.oldValue = oldValue;
        this.newValue = newValue;
        this.type = type;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("oldValue")
    public Object getOldValue() {
        return oldValue;
    }

    @JsonProperty("newValue")
    public Object getNewValue() {
        return newValue;
    }

    @JsonProperty("type")
    public DiffType getType() {
        return type;
    }
}
