package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;

import java.util.TreeMap;

public class Json {
    public static String json(TreeMap<String, Differ.Diff> calculateDiff) throws JsonProcessingException {
        ObjectMapper writer = new ObjectMapper();
        String result = writer.writeValueAsString(calculateDiff);
        return result;
    }
}
