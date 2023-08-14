package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class DataSupplier {

    public static Map<String, Object> doParsing(String content) throws Exception {
        String[] splittedLine = content.split("\\.");
        String type = splittedLine[1];
        Path path = Paths.get(content).toAbsolutePath().normalize();
        byte[] readsource = Files.readAllBytes(path);
        ParserFactory factory = new ParserFactory();
        if (type.equals("json")) {
            return factory.getParser(ParserTypes.JSON).parse(readsource);
        } else if (type.equals("yml")) {
            return factory.getParser(ParserTypes.YML).parse(readsource);
        } else {
            throw new RuntimeException(type + " is unknown type");
        }
    }

}
