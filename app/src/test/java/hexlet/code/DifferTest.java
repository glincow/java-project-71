package hexlet.code;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;

class DifferTest {

    @Test
    void testGenerateEmptyDiffJson() throws Exception {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1_empty.json");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2_empty.json");
        String diff = Differ.generate(file1, file2, "stylish");
        Assertions.assertEquals("\n{\n}", diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesJsonStylish() throws Exception {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1.json");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2.json");
        String diff = Differ.generate(file1, file2, "stylish");
        Assertions.assertEquals("\n{\n"
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
                + "}", diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesYamlStylish() throws Exception {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1.yml");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2.yml");
        String diff = Differ.generate(file1, file2, "stylish");
        Assertions.assertEquals("\n{\n"
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
                + "}", diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesJsonPlain() throws Exception {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1.json");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2.json");
        String diff = Differ.generate(file1, file2, "plain");
        Assertions.assertEquals(
                "\nProperty 'chars2' was updated. From [complex value] to false\n"
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
                        + "Property 'setting3' was updated. From true to 'none'",
                diff);
    }

    @Test
    void testGenerateDiffWithChangedValuesYamlPlain() throws Exception {
        Map<String, String> file1 = Parser.getData("src/test/resources/file1.yml");
        Map<String, String> file2 = Parser.getData("src/test/resources/file2.yml");
        String diff = Differ.generate(file1, file2, "plain");
        Assertions.assertEquals(
                "\nProperty 'chars2' was updated. From [complex value] to false\n"
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
                        + "Property 'setting3' was updated. From true to 'none'",
                diff);
    }
}
