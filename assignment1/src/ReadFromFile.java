import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFromFile {
    public ReadFromFile() {
    }

    public static String[] readFile(String path) {
        try {
            int i = 0;
            int lenght = Files.readAllLines(Paths.get(path)).size();
            String[] results = new String[lenght];
            for (String line : Files.readAllLines(Paths.get(path))) {
                results[i++] = line;
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
