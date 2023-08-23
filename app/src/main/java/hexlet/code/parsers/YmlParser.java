package hexlet.code.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.IOException;
import java.util.Map;

public class YmlParser implements Parser {
    public final Map<String, Object> parse(byte[] content) throws IOException {
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, Object> data = objectMapper.readValue(content, new TypeReference<>() { });
        return data;
    }
}
