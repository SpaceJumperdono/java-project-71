package hexlet.code;

public class ParserFactory {
    public static final Parser getParser(String type) {
        switch (type) {
            case "json":
                return new JsonParser();
            case "yml":
                return new YmlParser();
            default:
                throw new RuntimeException(type + " is unknown type");

        }
    }
}
