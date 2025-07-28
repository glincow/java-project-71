package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class FileParser {
    public static Map<String,String> getData(String path) throws IOException {
        return parse(readFile(path));
    }

    public static String readFile(String path) throws IOException {
        Path filePath = Paths.get(path).toAbsolutePath().normalize();
        if (!Files.exists(filePath)) {
            throw new IOException("File '" + path + "' does not exist");
        }
        return Files.readString(filePath);
    }

    public static Map<String, String> parse(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, Map.class);
    }
}
