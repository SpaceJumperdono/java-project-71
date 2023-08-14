package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class JsonParser implements Parser {
    public final Map<String, Object> parse(byte[] content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = objectMapper.readValue(content, new TypeReference<>() { });
        return data;
    }
}
