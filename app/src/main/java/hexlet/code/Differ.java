package hexlet.code;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {

    public static String generate(String style, String file1, String file2) throws Exception {
        Map<String, Object> dataFile1 = Parser.parsing(file1);
        Map<String, Object> dataFile2 = Parser.parsing(file2);
        switch (style) {
            default:
                return stylish(calculateDiff(dataFile1, dataFile2));
        }
    }


    public static TreeMap<String, LinkedHashMap<Object, String>> calculateDiff(Map dataFile1, Map dataFile2) {
        TreeMap<String, LinkedHashMap<Object, String>> result = new TreeMap<>();
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(dataFile1.keySet());
        allKeys.addAll(dataFile2.keySet());
        for (String iterator : allKeys) {
            LinkedHashMap<Object, String> diff = new LinkedHashMap<>();
            if (dataFile1.containsKey(iterator) && dataFile2.containsKey(iterator)) {
                if (Objects.equals(dataFile1.get(iterator), dataFile2.get(iterator))) {
                    diff.put(dataFile1.get(iterator), "unchanged");
                    result.put(iterator, diff);
                } else {
                    diff.put(dataFile1.get(iterator), "changed");
                    diff.put(dataFile2.get(iterator), "add");
                    result.put(iterator, diff);
                }
            } else {
                if (dataFile1.containsKey(iterator) && !dataFile2.containsKey(iterator)) {
                    diff.put(dataFile1.get(iterator), "delete");
                    result.put(iterator, diff);
                } else {
                    diff.put(dataFile2.get(iterator), "add");
                    result.put(iterator, diff);
                }
            }
        }
        return result;
    }

    public static String stylish(TreeMap<String, LinkedHashMap<Object, String>> calculateDiff) {
        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (String i: calculateDiff.keySet()) {
            LinkedHashMap<Object, String> value = calculateDiff.get(i);
            for (Object j : value.keySet()) {
                if (value.get(j).equals("unchanged")) {
                    result.append(" ".repeat(4) + i + ": " + j + "\n");
                } else if (value.get(j).equals("changed")) {
                    result.append(" ".repeat(2) + "- " + i + ": " + j + "\n");
                } else if (value.get(j).equals("delete")) {
                    result.append(" ".repeat(2) + "- " + i + ": " + j + "\n");
                } else {
                    result.append(" ".repeat(2) + "+ " + i + ": " + j + "\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }

}
