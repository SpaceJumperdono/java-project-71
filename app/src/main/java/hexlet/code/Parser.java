package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    private String type;
    public Parser(String type) {
        this.type = type;
    }

    public Map<String, Object> parsing(String filename) throws Exception {
        if (type.equals("json")) {
            return getJsonData(filename);
        } else if (type.equals("yml")) {
            return getYmlData(filename);
        } else {
            throw new RuntimeException(type + " is unknown type");
        }
    }
    public Map getJsonData(String content) throws Exception {
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readFile = Files.readAllBytes(path);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = objectMapper.readValue(readFile, new TypeReference<>() { });
        return data;
    }

    public Map getYmlData(String content) throws Exception {
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readFile = Files.readAllBytes(path);
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, String> data = objectMapper.readValue(readFile, new TypeReference<>() { });
        return data;
    }
}
