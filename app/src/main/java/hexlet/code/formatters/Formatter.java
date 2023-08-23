package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.DiffBuilder;
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
