import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


public class DifferTest {
    @Test
    void generateDiffTest1() throws Exception {
        Path path = Paths.get("src/test/resources/expected1").toAbsolutePath().normalize();
        String expected = Files.readString(path);
        assertThat(Differ.generate("stylish", "src/test/resources/file1.json",
                "src/test/resources/file2.json")).isEqualTo(expected);
    }
}
