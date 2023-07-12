package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App {
    @Option(names = {"-V", "--version"}, versionHelp = true, description = "Print version information and exit.")
    boolean versionInfoRequested;

    @Option(names = {"-h", "--help"}, usageHelp = true, description = "Show this help message and exit.")
    boolean usageHelpRequested;

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;

    @Parameters(index = "0", description = "path to first file")
    private File filepath1;

    @Parameters(index = "1", description = "path to second file")
    private File filepath2;
    public static void main(String... args) throws Exception {
        App app = CommandLine.populateCommand(new App(), args);
        if (app.usageHelpRequested) {
            CommandLine.usage(new App(), System.out);
            return;
        }
        String readFilePath = "txt";
        Map<String, Object> map = Differ.getData(readFilePath);

        // Выводим содержимое
        for (Map.Entry<String, Object> i : map.entrySet()) {
            System.out.println(i.getKey() + " " + i.getValue());
        }
    }

}




