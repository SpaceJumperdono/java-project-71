package hexlet.code;


import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.TreeMap;
public class Formatter {
    public static String choiceFormatter(TreeMap<String, Differ.Diff> calculateDiff, String style)
            throws JsonProcessingException {
        switch (style) {
            case "plain":
                return Plain.plain(calculateDiff);
            case "json":
                return Json.json(calculateDiff);
            default:
                return Stylish.stylish(calculateDiff);
        }
    }
}
