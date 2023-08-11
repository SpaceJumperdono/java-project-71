package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;

public class Differ {

    public static String generate(String file1, String file2, String style) throws Exception {
        Map<String, Object> dataFile1 = Parser.parsing(file1);
        Map<String, Object> dataFile2 = Parser.parsing(file2);
        TreeMap<String, Diff> calculateDiff = calculateDiff(dataFile1, dataFile2);
        return Formatter.choiceFormatter(calculateDiff, style);
    }

    public static String generate(String file1, String file2) throws Exception {
        Map<String, Object> dataFile1 = Parser.parsing(file1);
        Map<String, Object> dataFile2 = Parser.parsing(file2);
        TreeMap<String, Diff> calculateDiff = calculateDiff(dataFile1, dataFile2);
        return Formatter.choiceFormatter(calculateDiff, "stylish");
    }

    public static TreeMap<String, Diff> calculateDiff(Map dataFile1, Map dataFile2) {
        TreeMap<String, Diff> result = new TreeMap<>();
        TreeSet<String> allKeys = new TreeSet<>();
        allKeys.addAll(dataFile1.keySet());
        allKeys.addAll(dataFile2.keySet());
        for (String iterator : allKeys) {
            Object valueFile1 = dataFile1.get(iterator);
            Object valueFile2 = dataFile2.get(iterator);
            if (dataFile1.containsKey(iterator) && dataFile2.containsKey(iterator)) {
                if (Objects.equals(valueFile1, valueFile2)) {
                    result.put(iterator, new Diff("unchanged", valueFile1, valueFile2));
                } else {
                    result.put(iterator, new Diff("updated", valueFile1, valueFile2));
                }
            } else {
                if (dataFile1.containsKey(iterator) && !dataFile2.containsKey(iterator)) {
                    result.put(iterator, new Diff("removed", valueFile1, valueFile2));
                } else {
                    result.put(iterator, new Diff("added", valueFile1, valueFile2));
                }
            }
        }
        return result;
    }



    public static class Diff {
        private String status;
        private Object valueFile1;
        private Object valueFile2;

        public Diff(String status, Object valueFile1, Object valueFile2) {
            this.status = status;
            this.valueFile1 = valueFile1;
            this.valueFile2 = valueFile2;
        }

        public final String getStatus() {
            return status;
        }
        public final Object getValueFile1() {
            return valueFile1;
        }
        public final Object getValueFile2() {
            return valueFile2;
        }
    }
}
