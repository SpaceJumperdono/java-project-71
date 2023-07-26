import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class DifferTest {
    @Test
    void calculateDiffTest1() throws Exception {
        String expected = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(Differ.generate("yml","src/test/resources/test1.yml", "src/test/resources/test2.yml")).isEqualTo(expected);
    }

    @Test
    void calculateDiffTest2() throws Exception {
        String expected = "{\n  - follow: false\n    host: hexlet.io\n  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n  + timeout: 20\n  + verbose: true\n}";
        assertThat(Differ.generate("json","src/test/resources/file1.json", "src/test/resources/file2.json")).isEqualTo(expected);
    }
}
