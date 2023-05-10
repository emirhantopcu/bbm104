import java.util.ArrayList;

public class Updater {
    public Updater() {
    }                                   //updates a specified field of a Sport class object
    public void updater(String name, ArrayList<Sport> list, String target, int value) {
        switch (target) {
            case "games_won":
                for (Sport a : list) {
                    if (a.getTeam_name().equals(name)) {
                        a.addGames_won(value);
                    }
                }
                break;
            case "games_tie":
                for (Sport a : list) {
                    if (a.getTeam_name().equals(name)) {
                        a.addGames_tie(value);
                    }
                }
                break;
            case "games_lost":
                for (Sport a : list) {
                    if (a.getTeam_name().equals(name)) {
                        a.addGames_lost(value);
                    }
                }
                break;
            case "sets_won":
                for (Sport a : list) {
                    if (a.getTeam_name().equals(name)) {
                        a.addSets_won(value);
                    }
                }
                break;
            case "sets_lost":
                for (Sport a : list) {
                    if (a.getTeam_name().equals(name)) {
                        a.addSets_lost(value);
                    }
                }
                break;
            case "points":
                for (Sport a : list) {
                    if (a.getTeam_name().equals(name)) {
                        a.addPoints(value);
                    }
                }
                break;
        }
    }
}
