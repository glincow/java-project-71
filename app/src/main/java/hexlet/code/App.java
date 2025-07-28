package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format = "stylish";

    @Parameters(description = "path to first file")
    private String filepath1;
    @Parameters(description = " path to second file")
    private String filepath2;

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) {
        //int exitCode = new CommandLine(new App()).execute(args);
        //System.exit(exitCode);

        try {
            System.out.println(getData(readFile("src/main/resources/file1.json")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Map getData(String content) throws Exception {
        return parse(content);
    }

    public static String readFile(String path) throws Exception {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();

        System.out.println(filePath);

        if (!Files.exists(filePath)) {
            throw new Exception("File '" + path + "' does not exist");
        }

        return Files.readString(filePath);
    }

    public static Map parse(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, Map.class);
    }


}