package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DiffUtils;
import java.util.Map;

public class Json {
    public static String json(Map<String, DiffUtils.Diff> calculateDiff) throws JsonProcessingException {
        ObjectMapper writer = new ObjectMapper();
        String result = writer.writeValueAsString(calculateDiff);
        return result;
    }
}
