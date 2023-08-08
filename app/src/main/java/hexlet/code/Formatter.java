package hexlet.code;


import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.TreeMap;
public class Formatter {
    public static String choiceFormatter(TreeMap<String, Differ.Diff> calculateDiff, String style) {
        switch (style) {
            case "plain":
                return Plain.plain(calculateDiff);
            default:
                return Stylish.stylish(calculateDiff);
        }
    }
}
