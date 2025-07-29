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
        assertEquals("Some value", result.get("setting1"));
        assertEquals(200, result.get("setting2"));
        assertEquals(true, result.get("setting3"));
        assertEquals("value1", result.get("key1"));
        assertEquals(45, result.get("id"));
        assertEquals(null, result.get("default"));
        assertEquals(false, result.get("checked"));
    }

    @Test
    void testParseYamlFile() throws IOException {
        Map<String, Object> result = Parser.getData(YAML_FILE_PATH);

        assertEquals(12, result.size());
        assertEquals("Some value", result.get("setting1"));
        assertEquals(200, result.get("setting2"));
        assertEquals(true, result.get("setting3"));
        assertEquals("value1", result.get("key1"));
        assertEquals(45, result.get("id"));
        assertEquals(null, result.get("default"));
        assertEquals(false, result.get("checked"));
    }
}
