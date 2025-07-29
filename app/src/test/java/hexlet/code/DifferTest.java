package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Map;

class DifferTest {
    private static Map<String, Object> jsonFile1;
    private static Map<String, Object> jsonFile2;
    private static Map<String, Object> yamlFile1;
    private static Map<String, Object> yamlFile2;
    private static String expectedStylishDiff;
    private static String expectedPlainDiff;
    private static String expectedJsonDiff;

    @BeforeAll
    static void setUp() throws Exception {
        jsonFile1 = Parser.getData("src/test/resources/file1.json");
        jsonFile2 = Parser.getData("src/test/resources/file2.json");
        yamlFile1 = Parser.getData("src/test/resources/file1.yml");
        yamlFile2 = Parser.getData("src/test/resources/file2.yml");

        expectedStylishDiff = "\n{\n"
                + "    chars1: [a, b, c]\n"
                + "  - chars2: [d, e, f]\n"
                + "  + chars2: false\n"
                + "  - checked: false\n"
                + "  + checked: true\n"
                + "  - default: null\n"
                + "  + default: [value1, value2]\n"
                + "  - id: 45\n"
                + "  + id: null\n"
                + "  - key1: value1\n"
                + "  + key2: value2\n"
                + "    numbers1: [1, 2, 3, 4]\n"
                + "  - numbers2: [2, 3, 4, 5]\n"
                + "  + numbers2: [22, 33, 44, 55]\n"
                + "  - numbers3: [3, 4, 5]\n"
                + "  + numbers4: [4, 5, 6]\n"
                + "  + obj1: {nestedKey=value, isNested=true}\n"
                + "  - setting1: Some value\n"
                + "  + setting1: Another value\n"
                + "  - setting2: 200\n"
                + "  + setting2: 300\n"
                + "  - setting3: true\n"
                + "  + setting3: none\n"
                + "}";

        expectedPlainDiff = "\nProperty 'chars2' was updated. From [complex value] to false\n"
                + "Property 'checked' was updated. From false to true\n"
                + "Property 'default' was updated. From null to [complex value]\n"
                + "Property 'id' was updated. From 45 to null\n"
                + "Property 'key1' was removed\n"
                + "Property 'key2' was added with value: 'value2'\n"
                + "Property 'numbers2' was updated. From [complex value] to [complex value]\n"
                + "Property 'numbers3' was removed\n"
                + "Property 'numbers4' was added with value: [complex value]\n"
                + "Property 'obj1' was added with value: [complex value]\n"
                + "Property 'setting1' was updated. From 'Some value' to 'Another value'\n"
                + "Property 'setting2' was updated. From 200 to 300\n"
                + "Property 'setting3' was updated. From true to 'none'";

        expectedJsonDiff = "\n[{\"key\":\"chars1\",\"oldValue\":[\"a\",\"b\",\"c\"],"
                + "\"newValue\":[\"a\",\"b\",\"c\"],\"type\":\"UNCHANGED\"},"
                + "{\"key\":\"chars2\",\"oldValue\":[\"d\",\"e\",\"f\"],\"newValue\":false,"
                + "\"type\":\"CHANGED\"},{\"key\":\"checked\",\"oldValue\":false,\"newValue\":true,"
                + "\"type\":\"CHANGED\"},{\"key\":\"default\",\"oldValue\":null,"
                + "\"newValue\":[\"value1\",\"value2\"],\"type\":\"CHANGED\"},"
                + "{\"key\":\"id\",\"oldValue\":45,\"newValue\":null,\"type\":\"CHANGED\"},"
                + "{\"key\":\"key1\",\"oldValue\":\"value1\",\"newValue\":null,\"type\":\"DELETED\"},"
                + "{\"key\":\"key2\",\"oldValue\":null,\"newValue\":\"value2\",\"type\":\"ADDED\"},"
                + "{\"key\":\"numbers1\",\"oldValue\":[1,2,3,4],\"newValue\":[1,2,3,4],"
                + "\"type\":\"UNCHANGED\"},{\"key\":\"numbers2\",\"oldValue\":[2,3,4,5],"
                + "\"newValue\":[22,33,44,55],\"type\":\"CHANGED\"},"
                + "{\"key\":\"numbers3\",\"oldValue\":[3,4,5],\"newValue\":null,\"type\":\"DELETED\"},"
                + "{\"key\":\"numbers4\",\"oldValue\":null,\"newValue\":[4,5,6],\"type\":\"ADDED\"},"
                + "{\"key\":\"obj1\",\"oldValue\":null,\"newValue\":"
                + "{\"nestedKey\":\"value\",\"isNested\":true},\"type\":\"ADDED\"},"
                + "{\"key\":\"setting1\",\"oldValue\":\"Some value\","
                + "\"newValue\":\"Another value\",\"type\":\"CHANGED\"},"
                + "{\"key\":\"setting2\",\"oldValue\":200,\"newValue\":300,\"type\":\"CHANGED\"},"
                + "{\"key\":\"setting3\",\"oldValue\":true,\"newValue\":\"none\",\"type\":\"CHANGED\"}]";
    }

    @Test
    void testGenerateEmptyDiffJson() throws Exception {
        Map<String, Object> emptyFile1 = Parser.getData("src/test/resources/file1_empty.json");
        Map<String, Object> emptyFile2 = Parser.getData("src/test/resources/file2_empty.json");
        String diff = Differ.generate(emptyFile1, emptyFile2, "stylish");
        Assertions.assertEquals("\n{\n}", diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesJsonStylish() throws Exception {
        String diff = Differ.generate(jsonFile1, jsonFile2, "stylish");
        Assertions.assertEquals(expectedStylishDiff, diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesYamlStylish() throws Exception {
        String diff = Differ.generate(yamlFile1, yamlFile2, "stylish");
        Assertions.assertEquals(expectedStylishDiff, diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesJsonPlain() throws Exception {
        String diff = Differ.generate(jsonFile1, jsonFile2, "plain");
        Assertions.assertEquals(expectedPlainDiff, diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesYamlPlain() throws Exception {
        String diff = Differ.generate(yamlFile1, yamlFile2, "plain");
        Assertions.assertEquals(expectedPlainDiff, diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesJsonJson() throws Exception {
        String diff = Differ.generate(jsonFile1, jsonFile2, "json");
        Assertions.assertEquals(expectedJsonDiff, diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesYamlJson() throws Exception {
        String diff = Differ.generate(yamlFile1, yamlFile2, "json");
        Assertions.assertEquals(expectedJsonDiff, diff);
    }
}
