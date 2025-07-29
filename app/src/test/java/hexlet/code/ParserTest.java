package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    private static final String JSON_FILE_PATH = "src/test/resources/file1.json";
    private static final String YAML_FILE_PATH = "src/test/resources/file1.yml";

    @Test
    void testParseJsonFile() throws IOException {
        Map<String, String> result = Parser.getData(JSON_FILE_PATH);

        assertEquals(4, result.size());
        assertEquals("hexlet.io", result.get("host"));
        assertEquals(50, result.get("timeout"));
        assertEquals("123.234.53.22", result.get("proxy"));
        assertEquals(false, result.get("follow"));
    }

    @Test
    void testParseYamlFile() throws IOException {
        Map<String, String> result = Parser.getData(YAML_FILE_PATH);

        assertEquals(4, result.size());
        assertEquals("hexlet.io", result.get("host"));
        assertEquals(50, result.get("timeout"));
        assertEquals("123.234.53.22", result.get("proxy"));
        assertEquals(false, result.get("follow"));
    }
}