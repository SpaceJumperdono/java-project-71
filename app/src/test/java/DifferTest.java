import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;

public class DifferTest {

    @Test
    void calculateDiffTest1() {
        Map<String, Object> data1 = Map.of("host", "hexlet.io", "timeout", 50,
                "proxy", "123.234.53.22", "follow", false);
        Map<String, Object> data2 = Map.of("timeout", 20, "verbose", true, "host", "hexlet.io");
        String expected = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(Differ.calculateDiff(data1, data2)).isEqualTo(expected);
    }
}
