package hexlet.code.formatters;

import hexlet.code.DiffUtils;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    public static String plain(Map<String, DiffUtils.Diff> calculatedDiff) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, DiffUtils.Diff> entry : calculatedDiff.entrySet()) {
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
                default:
                    break;
            }

        }
        return result.toString().trim();
    }

    public static String checkeValue(Object value) {
        String result = null;
        if (value instanceof Map || value instanceof List || value instanceof Object[]) {
            result = "[complex value]";
        } else if (value instanceof String) {
            result = "'" + value + "'";
        } else {
            result = Objects.toString(value);
        }
        return result;
    }
}
