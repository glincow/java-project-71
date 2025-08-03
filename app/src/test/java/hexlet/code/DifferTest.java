package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class DifferTest {
    private static String jsonPath1;
    private static String jsonPath2;
    private static String yamlPath1;
    private static String yamlPath2;
    private static String resultJson;
    private static String resultPlain;
    private static String resultStylish;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        jsonPath1 = "src/test/resources/file1.json";
        jsonPath2 = "src/test/resources/file2.json";
        yamlPath1 = "src/test/resources/file1.yml";
        yamlPath2 = "src/test/resources/file2.yml";
        resultJson = readFixture("result_json.json");
        resultPlain = readFixture("result_plain.txt");
        resultStylish = readFixture("result_stylish.txt");
    }

    @Test
    void testGenerateEmptyDiffJson() throws Exception {
        String emptyPath1 = "src/test/resources/file1_empty.json";
        String emptyPath2 = "src/test/resources/file2_empty.json";
        String diff = Differ.generate(emptyPath1, emptyPath2, "stylish");
        Assertions.assertEquals("{\n}", diff);
    }

    // JSON input tests
    @Test
    void testGenerateDiffJsonWithStylishFormat() throws Exception {
        String diff = Differ.generate(jsonPath1, jsonPath2, "stylish");
        Assertions.assertEquals(resultStylish, diff);
    }

    @Test
    void testGenerateDiffJsonWithPlainFormat() throws Exception {
        String diff = Differ.generate(jsonPath1, jsonPath2, "plain");
        Assertions.assertEquals(resultPlain, diff);
    }

    @Test
    void testGenerateDiffJsonWithJsonFormat() throws Exception {
        String diff = Differ.generate(jsonPath1, jsonPath2, "json");
        Assertions.assertEquals(resultJson, diff);
    }

    @Test
    void testGenerateDiffJsonWithDefaultFormat() throws Exception {
        String diff = Differ.generate(jsonPath1, jsonPath2);
        Assertions.assertEquals(resultStylish, diff);
    }

    // YAML input tests
    @Test
    void testGenerateDiffYamlWithStylishFormat() throws Exception {
        String diff = Differ.generate(yamlPath1, yamlPath2, "stylish");
        Assertions.assertEquals(resultStylish, diff);
    }

    @Test
    void testGenerateDiffYamlWithPlainFormat() throws Exception {
        String diff = Differ.generate(yamlPath1, yamlPath2, "plain");
        Assertions.assertEquals(resultPlain, diff);
    }

    @Test
    void testGenerateDiffYamlWithJsonFormat() throws Exception {
        String diff = Differ.generate(yamlPath1, yamlPath2, "json");
        Assertions.assertEquals(resultJson, diff);
    }

    @Test
    void testGenerateDiffYamlWithDefaultFormat() throws Exception {
        String diff = Differ.generate(yamlPath1, yamlPath2);
        Assertions.assertEquals(resultStylish, diff);
    }
}
