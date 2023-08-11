package hexlet.code.formatters;

import hexlet.code.Differ;

import java.util.Map;
import java.util.TreeMap;

public class Stylish {
    public static final int SPACES = 4;
    public static String stylish(TreeMap<String, Differ.Diff> calculateDiff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, Differ.Diff> entry : calculateDiff.entrySet()) {
            if (entry.getValue().getStatus().equals("unchanged")) {
                result.append(" ".repeat(SPACES) + entry.getKey() + ": " + entry.getValue().getValueFile1() + "\n");
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
}
