package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Differ {

    public static String generate(String file1, String file2) throws Exception {
        Map<String, Object> dataFile1 = getData(file1);
        Map<String, Object> dataFile2 = getData(file2);
        String result = calculateDiff(dataFile1, dataFile2);
        return result;
    }
    public static Map getData(String content) throws Exception {
        Map<String, String> data = new HashMap<>();
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readFile = Files.readAllBytes(path);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = objectMapper.readValue(readFile, new TypeReference<>() { });
        return map;
    }

    public static String calculateDiff(Map dataFile1, Map dataFile2) {
        StringBuilder result = new StringBuilder();
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(dataFile1.keySet());
        allKeys.addAll(dataFile2.keySet());
        result.append("{\n");
        for (String i : allKeys) {
            if (dataFile1.containsKey(i) && dataFile2.containsKey(i)) {
                if (dataFile1.get(i).equals(dataFile2.get(i))) {
                    result.append("    " + i + ": " + dataFile1.get(i).toString() + "\n");
                } else {
                    result.append("  - " + i + ": " + dataFile1.get(i).toString() + "\n");
                    result.append(("  + " + i + ": " + dataFile2.get(i).toString()) + "\n");
                }
            } else if (dataFile1.containsKey(i) && !dataFile2.containsKey(i)) {
                result.append("  - " + i + ": " + dataFile1.get(i).toString() + "\n");
            } else {
                result.append("  + " + i + ": " + dataFile2.get(i).toString() + "\n");
            }
        }
        result.append("}");
        return result.toString();
    }
}
