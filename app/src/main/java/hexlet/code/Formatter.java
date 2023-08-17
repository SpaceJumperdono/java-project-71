package hexlet.code;


import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String chooseFormatter(Map<String, DiffBuilder.Diff> diff, String style)
            throws JsonProcessingException {
        switch (style) {
            case "plain":
                return Plain.plain(diff);
            case "json":
                return Json.json(diff);
            case "stylish":
                return Stylish.stylish(diff);
            default:
                throw new RuntimeException();
        }
    }
}
