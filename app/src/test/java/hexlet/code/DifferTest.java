package hexlet.code;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

class DifferTest {

    @Test
    void testGenerateEmptyDiffJson() throws IOException {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1_empty.json");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2_empty.json");
        String diff = Differ.generate(file1, file2);
        Assertions.assertEquals("\n{\n}", diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesJson() throws IOException {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1.json");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2.json");
        String diff = Differ.generate(file1, file2);
        Assertions.assertEquals("\n{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}", diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesYaml() throws IOException {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1.yml");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2.yml");
        String diff = Differ.generate(file1, file2);
        Assertions.assertEquals("\n{\n"
                + "  - follow: false\n"
                + "    host: hexlet.io\n"
                + "  - proxy: 123.234.53.22\n"
                + "  - timeout: 50\n"
                + "  + timeout: 20\n"
                + "  + verbose: true\n"
                + "}", diff);
    }
}
