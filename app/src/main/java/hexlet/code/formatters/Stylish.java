package hexlet.code.formatters;

import hexlet.code.DiffUtils;
import java.util.Map;

public class Stylish {
    public static final int SPACES = 4;
    public static String stylish(Map<String, DiffUtils.Diff> calculateDiff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, DiffUtils.Diff> entry : calculateDiff.entrySet()) {
            String status = entry.getValue().getStatus();
            switch (status) {
                case "added":
                    result.append(" ".repeat(2) + "+ " + entry.getKey() + ": " + entry.getValue().getValue2() + "\n");
                    break;
                case "updated":
                    result.append(" ".repeat(2) + "- " + entry.getKey() + ": " + entry.getValue().getValue1() + "\n");
                    result.append(" ".repeat(2) + "+ " + entry.getKey() + ": " + entry.getValue().getValue2() + "\n");
                    break;
                case "removed":
                    result.append(" ".repeat(2) + "- " + entry.getKey() + ": " + entry.getValue().getValue1() + "\n");
                    break;
                default:
                    result.append(" ".repeat(SPACES) + entry.getKey() + ": " + entry.getValue().getValue1() + "\n");
                    break;
            }
        }
        result.append("}");
        return result.toString();
    }
}
