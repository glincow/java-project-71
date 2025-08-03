package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> getData(String content, String format) throws IOException {
        return switch (format) {
            case "json" -> parseJson(content);
            case "yaml", "yml" -> parseYaml(content);
            default -> throw new IOException("Unsupported file format: " + format);
        };
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
