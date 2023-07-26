package hexlet.code;

import java.util.Map;
import java.util.TreeSet;

public class Differ {

    public static String generate(String type, String file1, String file2) throws Exception {
        Parser parser = new Parser(type);
        Map<String, Object> dataFile1 = parser.parsing(file1);
        Map<String, Object> dataFile2 = parser.parsing(file2);

        String result = calculateDiff(dataFile1, dataFile2);
        return result;
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
