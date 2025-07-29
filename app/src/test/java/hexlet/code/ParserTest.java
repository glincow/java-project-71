package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParserTest {

    private static final String JSON_FILE_PATH = "src/test/resources/file1.json";
    private static final String YAML_FILE_PATH = "src/test/resources/file1.yml";
    private static final int EXPECTED_MAP_SIZE = 12;
    private static final int SETTING_TWO_VALUE = 200;
    private static final int ID_VALUE = 45;

    @Test
    void testParseJsonFile() throws IOException {
        Map<String, Object> result = Parser.getData(JSON_FILE_PATH);

        assertEquals(EXPECTED_MAP_SIZE, result.size());
        assertEquals("Some value", result.get("setting1"));
        assertEquals(SETTING_TWO_VALUE, result.get("setting2"));
        assertEquals(true, result.get("setting3"));
        assertEquals("value1", result.get("key1"));
        assertEquals(ID_VALUE, result.get("id"));
        assertNull(result.get("default"));
        assertEquals(false, result.get("checked"));
    }

    @Test
    void testParseYamlFile() throws IOException {
        Map<String, Object> result = Parser.getData(YAML_FILE_PATH);

        assertEquals(EXPECTED_MAP_SIZE, result.size());
        assertEquals("Some value", result.get("setting1"));
        assertEquals(SETTING_TWO_VALUE, result.get("setting2"));
        assertEquals(true, result.get("setting3"));
        assertEquals("value1", result.get("key1"));
        assertEquals(ID_VALUE, result.get("id"));
        assertNull(result.get("default"));
        assertEquals(false, result.get("checked"));
    }
}
