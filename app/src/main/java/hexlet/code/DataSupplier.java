package hexlet.code;

import hexlet.code.parsers.ParserFactory;

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
        return ParserFactory.getParser(type).parse(readsource);
    }

}
