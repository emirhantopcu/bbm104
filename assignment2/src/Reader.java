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
    public void writeFile(Path file, ArrayList<String> lines){
        try{
            Files.write(file, lines);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void outputWriter(Personnel personnel){
        ArrayList<String> outputlines = new ArrayList<>();
        outputlines.add("Name : "+personnel.getName().split(" ")[0]);
        outputlines.add("Surname : "+personnel.getName().split(" ")[1]);
        outputlines.add("Registiration Number : "+personnel.getId());
        outputlines.add("Position : "+personnel.getPositionname());
        outputlines.add("Year of Start : "+ personnel.getYearofstart());
        outputlines.add("Total Salary : "+ personnel.getSalary()+".00 TL");
        Path path = Paths.get(personnel.getId()+".txt");
        writeFile(path, outputlines);
    }
}
