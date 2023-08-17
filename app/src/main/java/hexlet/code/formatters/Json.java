package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffBuilder;
import java.util.Map;

public class Json {
    public static String json(Map<String, DiffBuilder.Diff> calculateDiff) throws JsonProcessingException {
        ObjectMapper writer = new ObjectMapper();
        String result = writer.writeValueAsString(calculateDiff);
        return result;
    }
}
