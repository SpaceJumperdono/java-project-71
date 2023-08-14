package hexlet.code;


import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Objects;
public class DiffUtils {
    public static Map<String, Diff> calculateDiff(Map data1, Map data2) {
        Map<String, Diff> result = new TreeMap<>();
        Set<String> allKeys = new TreeSet<>();
        allKeys.addAll(data1.keySet());
        allKeys.addAll(data2.keySet());
        for (String key : allKeys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (Objects.equals(value1, value2)) {
                    result.put(key, new Diff("unchanged", value1, value2));
                } else {
                    result.put(key, new Diff("updated", value1, value2));
                }
            } else if (data1.containsKey(key) && !data2.containsKey(key)) {
                result.put(key, new Diff("removed", value1, value2));
            } else if (!data1.containsKey(key) && data2.containsKey(key)) {
                result.put(key, new Diff("added", value1, value2));
            }
        }
        return result;
    }
    public static class Diff {
        private String status;
        private Object value1;
        private Object value2;

        public Diff(String status, Object value1, Object value2) {
            this.status = status;
            this.value1 = value1;
            this.value2 = value2;
        }

        public final String getStatus() {
            return status;
        }
        public final Object getValue1() {
            return value1;
        }
        public final Object getValue2() {
            return value2;
        }
    }
}
