package hexlet.code.formatters;

import hexlet.code.DiffBuilder;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    public static String plain(Map<String, DiffBuilder.Diff> calculatedDiff) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, DiffBuilder.Diff> entry : calculatedDiff.entrySet()) {
            String status = entry.getValue().getStatus();
            String value1 = checkeValue(entry.getValue().getValue1());
            String value2 = checkeValue(entry.getValue().getValue2());
            switch (status) {
                case "updated":
                    result.append(String.format("Property '%s' was updated. From %s to %s\n",
                            entry.getKey(), value1, value2));
                    break;
                case "added":
                    result.append(String.format("Property '%s' was added with value: %s\n",
                            entry.getKey(), value2));
                    break;
                case "removed":
                    result.append(String.format("Property '%s' was removed\n",
                            entry.getKey()));
                    break;
                case "unchanged":
                    break;
                default:
                    throw new RuntimeException("Unknown status");
            }

        }
        return result.toString().trim();
    }

    public static String checkeValue(Object value) {
        if (value instanceof Map || value instanceof List || value instanceof Object[]) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return Objects.toString(value);
        }
    }
}
