import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;


public class DifferTest {
    private static String expected1;
    private static String expected2;
    private static String expected3;
    @BeforeAll
    public static void beforeAll() throws IOException {
        Path path1 = Paths.get("src/test/resources/expected1").toAbsolutePath().normalize();
        expected1 = Files.readString(path1);

        Path path2 = Paths.get("src/test/resources/expected2").toAbsolutePath().normalize();
        expected2 = Files.readString(path2);

        Path path3 = Paths.get("src/test/resources/expected3").toAbsolutePath().normalize();
        expected3 = Files.readString(path3);

    }
    @Test
    void generateDiffTest1() throws Exception {
        String diff = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");

        assertThat(diff).isEqualTo(expected1);
    }

    @Test
    void generateDiffTest2() throws Exception {
        String diff = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain");
        assertThat(diff).isEqualTo(expected2);
    }

    @Test
    void generateDiffTest3() throws Exception {
        String diff = Differ.generate("src/test/resources/file3.yml",
                "src/test/resources/file4.yml", "stylish");
        assertThat(diff).isEqualTo(expected1);
    }

    @Test
    void generateDiffTest4() throws Exception {
        String diff = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json");
        assertThat(diff).isEqualTo(expected3);
    }

    @Test
    void generateDiffWithTwoArguments() throws Exception {
        String diff = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        assertThat(diff).isEqualTo(expected1);
    }
}
