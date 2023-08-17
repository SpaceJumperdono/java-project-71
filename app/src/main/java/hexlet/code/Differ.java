package hexlet.code;


import java.util.Map;

public class Differ {

    public static String generate(String path1, String path2, String style) throws Exception {
        Map<String, Object> data1 = DataSupplier.doParsing(path1);
        Map<String, Object> data2 = DataSupplier.doParsing(path2);
        Map<String, DiffBuilder.Diff> calculateDiff = DiffBuilder.calculateDiff(data1, data2);
        return Formatter.chooseFormatter(calculateDiff, style);
    }

    public static String generate(String path1, String path2) throws Exception {
        return generate(path1, path2, "stylish");
    }

}
