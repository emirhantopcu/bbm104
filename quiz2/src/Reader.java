import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Reader {
    public Reader() {
    }

    public String[] readFile(String path) {
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
    public void writeFile(Path file, ArrayList<String> lines){
        try{
            Files.write(file, lines);
        }catch(IOException e){
            e.printStackTrace();
        }
    }                                       //takes each club in each list and puts the information about them
                                            //in wanted output format
    public ArrayList<String> outputFormat(ArrayList<Sport> list){
        ArrayList<String> lines = new ArrayList<>();
        for (Sport a : list){
            lines.add((list.indexOf(a)+1) +".\t"+a.getTeam_name()+"\t"+(a.getGames_lost()+a.getGames_won()+a.getGames_tie())
                    +"\t"+ a.getGames_won() +"\t"+ a.getGames_tie() + "\t"+ a.getGames_lost() + "\t" + a.getSets_won()+":"
                    +a.getSets_lost()+"\t"+a.getPoints());
        }
        return lines;
    }
}
