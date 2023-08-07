package hexlet.code;


import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.List;
public class Formatter {
    public static String stylish(TreeMap<String, Differ.Diff> calculateDiff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Differ.Diff> entry : calculateDiff.entrySet()) {
            if (entry.getValue().getStatus().equals("unchanged")) {
                result.append(" ".repeat(4) + entry.getKey() + ": " + entry.getValue().getValueFile1() + "\n");
            } else if (entry.getValue().getStatus().equals("updated")) {
                result.append(" ".repeat(2) + "- " + entry.getKey() + ": " + entry.getValue().getValueFile1() + "\n");
                result.append(" ".repeat(2) + "+ " + entry.getKey() + ": " + entry.getValue().getValueFile2() + "\n");
            } else if (entry.getValue().getStatus().equals("removed")) {
                result.append(" ".repeat(2) + "- " + entry.getKey() + ": " + entry.getValue().getValueFile1() + "\n");
            } else {
                result.append(" ".repeat(2) + "+ " + entry.getKey() + ": " + entry.getValue().getValueFile2() + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }

    public static String plain(TreeMap<String, Differ.Diff> calculatedDiff) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Differ.Diff> entry : calculatedDiff.entrySet()) {
            if (entry.getValue().getStatus().equals("unchanged")) {
                continue;
            }
            result.append("Property " + "'" + entry.getKey() + "'" + " was ");
            String value1 = checkeValue(entry.getValue().getValueFile1());
            String value2 = checkeValue(entry.getValue().getValueFile2());

            if (entry.getValue().getStatus().equals("updated")) {
                result.append("updated. From " + value1 + " to " + value2 + "\n");
            } else if (entry.getValue().getStatus().equals("added")) {
                result.append("added with value: " + value2 + "\n");
            } else if (entry.getValue().getStatus().equals("removed")) {
                result.append("removed\n");
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
