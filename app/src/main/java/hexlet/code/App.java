package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Command;
import java.util.Map;
import java.util.concurrent.Callable;
import picocli.CommandLine.Parameters;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    @Option(names = {"-f", "--format"},  defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @Parameters(description = "path to first file")
    private String filepath1;
    @Parameters(description = " path to second file")
    private String filepath2;

    @Override
    public Integer call() {
        try {
            Map<String, Object> data1 = Parser.getData(filepath1);
            Map<String, Object> data2 = Parser.getData(filepath2);
            System.out.println(Differ.generate(data1, data2, format));
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
