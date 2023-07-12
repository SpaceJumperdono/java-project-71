package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Differ {

    public static Map getData(String content) throws Exception {
        Map<String, String> data = new HashMap<>();
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readFile = Files.readAllBytes(path);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(readFile, new TypeReference<>() {});
        return map;
    }
}
