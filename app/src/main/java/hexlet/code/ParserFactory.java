package hexlet.code;

public class ParserFactory {
    public Parser getParser(ParserTypes type) {
        switch (type) {
            case JSON:
                return new JsonParser();
            default:
                return new YmlParser();

        }
    }
}
