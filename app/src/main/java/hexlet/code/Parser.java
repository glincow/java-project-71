package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String path) throws IOException {
        String fileExtension = getFileExtension(path);
        String fileContent = readFile(path);

        switch (fileExtension) {
            case "json":
                return parseJson(fileContent);
            case "yaml":
            case "yml":
                return parseYaml(fileContent);
            default:
                throw new IOException("Unsupported file extension: " + fileExtension);
        }
    }

    private static String getFileExtension(String path) {
        int lastDotIndex = path.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return "";
        }
        return path.substring(lastDotIndex + 1);
    }

    private static String readFile(String path) throws IOException {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new IOException("File '" + path + "' does not exist");
        }
        return Files.readString(filePath);
    }

    private static Map<String, Object> parseJson(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, Map.class);
    }

    private static Map<String, Object> parseYaml(String content) throws IOException {
        YAMLFactory yamlFactory = new YAMLFactory();
        YAMLParser yamlParser = yamlFactory.createParser(content);
        ObjectMapper objectMapper = new ObjectMapper(yamlFactory);
        return objectMapper.readValue(yamlParser, Map.class);
    }
}
