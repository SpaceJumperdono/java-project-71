package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parsing(String filename) throws Exception {
        String[] splittedLine = filename.split("\\.");
        String type = splittedLine[1];
        if (type.equals("json")) {
            return Parser.getJsonData(filename);
        } else if (type.equals("yml")) {
            return Parser.getYmlData(filename);
        } else {
            throw new RuntimeException(type + " is unknown type");
        }
    }
    public static Map getJsonData(String content) throws Exception {
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readFile = Files.readAllBytes(path);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = objectMapper.readValue(readFile, new TypeReference<>() { });
        return data;
    }

    public static Map getYmlData(String content) throws Exception {
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readFile = Files.readAllBytes(path);
        ObjectMapper objectMapper = new YAMLMapper();
        Map<String, Object> data = objectMapper.readValue(readFile, new TypeReference<>() { });
        return data;
    }
}
