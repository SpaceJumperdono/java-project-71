package hexlet.code.formatters;

import hexlet.code.DiffBuilder;
import java.util.Map;

public class Stylish {
    public static final int SPACES = 4;
    public static String stylish(Map<String, DiffBuilder.Diff> calculateDiff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (Map.Entry<String, DiffBuilder.Diff> entry : calculateDiff.entrySet()) {
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
                case "unchanged":
                    result.append(" ".repeat(SPACES) + entry.getKey() + ": " + entry.getValue().getValue1() + "\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status");
            }
        }
        result.append("}");
        return result.toString();
    }
}
