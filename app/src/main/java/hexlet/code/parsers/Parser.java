package hexlet.code.parsers;

import java.io.IOException;
import java.util.Map;
public interface Parser {
    Map<String, Object> parse(byte[] content) throws IOException;
}
