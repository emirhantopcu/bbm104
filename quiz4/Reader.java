import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reader {
    public Reader() {
    }

    public ArrayList<String> readFile(String path) {
        try {
            ArrayList<String> results = new ArrayList<>();
            for (String line : Files.readAllLines(Paths.get(path))) {
                results.add(line);
            }
            return results;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void appendFile(File file, String line){
        try{
            FileWriter writer = new FileWriter(file, true);
            writer.write(line+"\n");
            writer.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
