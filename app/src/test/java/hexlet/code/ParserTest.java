package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParserTest {

    private static final String JSON_FILE_PATH = "src/test/resources/file1.json";
    private static final String YAML_FILE_PATH = "src/test/resources/file1.yml";

    @Test
    void testParseJsonFile() throws IOException {
        Map<String, Object> result = Parser.getData(JSON_FILE_PATH);

        assertEquals(12, result.size());
    }

    @Test
    void testParseYamlFile() throws IOException {
        Map<String, Object> result = Parser.getData(YAML_FILE_PATH);

        assertEquals(12, result.size());
    }
}
