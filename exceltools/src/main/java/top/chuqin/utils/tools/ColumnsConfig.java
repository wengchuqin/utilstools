package top.chuqin.utils.tools;

import java.util.*;
import java.util.function.Consumer;

public class ColumnsConfig {
    TreeSet<ConfigItem> configItems = new TreeSet<ConfigItem>();

    public ColumnsConfig add(String label, String field) {
        int seq = configItems.isEmpty() ? 0 : configItems.last().sequence + 1;
        configItems.add(new ConfigItem(seq, label, field));
        return this;
    }

    public ColumnsConfig set(int sequence, String label, String field) {
        configItems.forEach(configItem -> {
            if (configItem.sequence == sequence) {
                throw new ColumnSequenceDuplicateException(sequence);
            }
        });

        configItems.add(new ConfigItem(sequence, label, field));
        return this;
    }

    @Override
    public String toString() {
        return "ColumnsConfig{" +
                "configItems=" + configItems +
                '}';
    }
}

class ConfigItem implements Comparable<ConfigItem> {
    int sequence;
    String label;
    String field;

    public ConfigItem(int sequence, String label, String field) {
        if (label == null) {
            label = "";
        }
        if (field == null) {
            throw new RuntimeException("field不能为空");
        }

        this.sequence = sequence;
        this.label = label;
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigItem item = (ConfigItem) o;
        return sequence == item.sequence &&
                Objects.equals(label, item.label) &&
                Objects.equals(field, item.field);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sequence, label, field);
    }

    @Override
    public String toString() {
        return "ConfigItem{" +
                "sequence=" + sequence +
                ", label='" + label + '\'' +
                ", field='" + field + '\'' +
                '}';
    }

    @Override
    public int compareTo(ConfigItem o) {
        return Integer.compare(this.sequence, o.sequence);
    }
}