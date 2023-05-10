import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        Reader reader = new Reader();
        String[] games = reader.readFile(args[0]);
        ArrayList<Sport> ice_hockey_clubs = new ArrayList<>();
        ArrayList<Sport> handball_clubs = new ArrayList<>();
        ArrayList<Sport> basketball_clubs = new ArrayList<>();
        ArrayList<Sport> volleyball_clubs = new ArrayList<>();
        for (String game : games) {
            String game_type = game.split("\t")[0];
            switch (game_type) {
                case "I": {
                    analyzer.clubAnalyzer(game, ice_hockey_clubs, game_type);
                    break;
                }
                case "H": {
                    analyzer.clubAnalyzer(game, handball_clubs, game_type);
                    break;
                }
                case "B": {
                    analyzer.clubAnalyzer(game, basketball_clubs, game_type);
                    break;
                }
                case "V": {
                    analyzer.clubAnalyzer(game, volleyball_clubs, game_type);
                    break;
                }
            }
        }
        for (String game : games) {
            String game_type = game.split("\t")[0];
            switch (game_type) {
                case "I":
                    analyzer.gameAnalyzer(game_type, game, ice_hockey_clubs);
                    break;
                case "H":
                    analyzer.gameAnalyzer(game_type, game, handball_clubs);
                    break;
                case "B":
                    analyzer.gameAnalyzer(game_type, game, basketball_clubs);
                    break;
                case "V":
                    analyzer.gameAnalyzer(game_type, game, volleyball_clubs);
                    break;
            }
        }
        analyzer.clubSorter(ice_hockey_clubs);
        analyzer.clubSorter(handball_clubs);
        analyzer.clubSorter(basketball_clubs);
        analyzer.clubSorter(volleyball_clubs);

        Path fileI = Paths.get("icehockey.txt");
        Path fileH = Paths.get("handball.txt");
        Path fileB = Paths.get("basketball.txt");
        Path fileV = Paths.get("volleyball.txt");

        reader.writeFile(fileI, reader.outputFormat(ice_hockey_clubs));
        reader.writeFile(fileH, reader.outputFormat(handball_clubs));
        reader.writeFile(fileB, reader.outputFormat(basketball_clubs));
        reader.writeFile(fileV, reader.outputFormat(volleyball_clubs));
    }
}
