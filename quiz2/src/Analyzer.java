import java.util.ArrayList;
import java.util.Collections;

public class Analyzer {
    public Analyzer() {
    }
    public void clubAnalyzer(String game, ArrayList<Sport> club_list, String case_) {
        String c1 = game.split("\t")[1];
        String c2 = game.split("\t")[2];            //finds every sport club given in the input file
        switch (case_){                                   //and creates them as objects of their own class
            case("I"):
                if (club_list.size() == 0) {
                    IceHockey club1 = new IceHockey(c1, 0 ,0,0,0,0,0);
                    IceHockey club2 = new IceHockey(c2, 0 ,0,0,0,0,0);
                    club_list.add(club1);
                    club_list.add(club2);
                }else{
                    boolean statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c1)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        IceHockey club3 = new IceHockey(c1, 0 ,0,0,0,0,0);
                        club_list.add(club3);
                    }
                    statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c2)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        IceHockey club4 = new IceHockey(c2, 0 ,0,0,0,0,0);
                        club_list.add(club4);
                    }
                }
                break;
            case("H"):
                if (club_list.size() == 0) {
                    Handball club1 = new Handball(c1, 0 ,0,0,0,0,0);
                    Handball club2 = new Handball(c2, 0 ,0,0,0,0,0);
                    club_list.add(club1);
                    club_list.add(club2);
                }else{
                    boolean statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c1)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        Handball club3 = new Handball(c1, 0 ,0,0,0,0,0);
                        club_list.add(club3);
                    }
                    statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c2)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        Handball club4 = new Handball(c2, 0 ,0,0,0,0,0);
                        club_list.add(club4);
                    }
                }
                break;
            case("B"):
                if (club_list.size() == 0) {
                    Basketball club1 = new Basketball(c1, 0 ,0,0,0,0,0);
                    Basketball club2 = new Basketball(c2, 0 ,0,0,0,0,0);
                    club_list.add(club1);
                    club_list.add(club2);
                }else{
                    boolean statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c1)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        Basketball club3 = new Basketball(c1, 0 ,0,0,0,0,0);
                        club_list.add(club3);
                    }
                    statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c2)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        Basketball club4 = new Basketball(c2, 0 ,0,0,0,0,0);
                        club_list.add(club4);
                    }
                }
                break;
            case("V"):
                if (club_list.size() == 0) {
                    Volleyball club1 = new Volleyball(c1, 0 ,0,0,0,0,0);
                    Volleyball club2 = new Volleyball(c2, 0 ,0,0,0,0,0);
                    club_list.add(club1);
                    club_list.add(club2);
                }else{
                    boolean statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c1)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        Volleyball club3 = new Volleyball(c1, 0 ,0,0,0,0,0);
                        club_list.add(club3);
                    }
                    statusFound = false;
                    for (Sport club : club_list){
                        if (club.getTeam_name().equals(c2)) {
                            statusFound = true;
                        }
                    }
                    if (!statusFound) {
                        Volleyball club4 = new Volleyball(c2, 0 ,0,0,0,0,0);
                        club_list.add(club4);
                    }
                }
                break;
        }
    }                                       //takes one line of input at one time and does the scoring
    public void gameAnalyzer(String case_, String game, ArrayList<Sport> list) {
        Updater u = new Updater();
        String club1 = game.split("\t")[1];
        String club2 = game.split("\t")[2];
        int club1set = Integer.parseInt(game.split("\t")[3].split(":")[0]);
        int club2set = Integer.parseInt(game.split("\t")[3].split(":")[1]);
        switch (case_) {
            case("I"):
                if(club1set > club2set) {
                    u.updater(club1, list, "games_won", 1 );
                    u.updater(club2, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 3   );
                }else if(club1set < club2set){
                    u.updater(club2, list, "games_won", 1 );
                    u.updater(club1, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club2, list, "points", 3   );
                }else if(club1set == club2set){
                    u.updater(club1, list, "games_tie", 1 );
                    u.updater(club2, list, "games_tie", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 1   );
                    u.updater(club2, list, "points", 1   );
                }
                break;
            case("H"):
                if(club1set > club2set) {
                    u.updater(club1, list, "games_won", 1 );
                    u.updater(club2, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 2   );
                }else if(club1set < club2set){
                    u.updater(club2, list, "games_won", 1 );
                    u.updater(club1, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club2, list, "points", 2   );
                }else if(club1set == club2set){
                    u.updater(club1, list, "games_tie", 1 );
                    u.updater(club2, list, "games_tie", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 1   );
                    u.updater(club2, list, "points", 1   );
                }
                break;
            case("B"):
                if(club1set > club2set) {
                    u.updater(club1, list, "games_won", 1 );
                    u.updater(club2, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 2   );
                    u.updater(club2, list, "points", 1   );
                }else if(club1set < club2set){
                    u.updater(club2, list, "games_won", 1 );
                    u.updater(club1, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club2, list, "points", 2   );
                    u.updater(club1, list, "points", 1   );
                }
                break;
            case("V"):
                if((club1set == 3 && club2set == 0) || (club1set == 3 && club2set == 1)) {
                    u.updater(club1, list, "games_won", 1 );
                    u.updater(club2, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 3   );
                }else if(club1set == 3 && club2set == 2){
                    u.updater(club1, list, "games_won", 1 );
                    u.updater(club2, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club1, list, "points", 2   );
                    u.updater(club2, list, "points", 1   );
                }else if((club2set == 3 && club1set == 0) || (club2set == 3 && club1set == 1)) {
                    u.updater(club2, list, "games_won", 1 );
                    u.updater(club1, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club2, list, "points", 3   );
                    u.updater(club1, list, "points", 0   );
                }else if(club2set == 3 && club1set == 2) {
                    u.updater(club2, list, "games_won", 1 );
                    u.updater(club1, list, "games_lost", 1   );
                    u.updater(club1, list, "sets_won", club1set   );
                    u.updater(club2, list, "sets_won", club2set   );
                    u.updater(club1, list, "sets_lost", club2set   );
                    u.updater(club2, list, "sets_lost", club1set   );
                    u.updater(club2, list, "points", 2   );
                    u.updater(club1, list, "points", 1   );
                }
                break;
        }
    }                                               //sorts groups of sport clubs in their own lists
    public void clubSorter(ArrayList<Sport> list){
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getPoints() < list.get(i+1).getPoints()) {
                    Collections.swap(list, i+1, i);
                    sorted = false;
                }
            }
        }
        sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).getPoints() == list.get(i+1).getPoints()) {
                    if ((list.get(i).getSets_won() - list.get(i).getSets_lost()) < (list.get(i+1).getSets_won() - list.get(i+1).getSets_lost())){
                        Collections.swap(list, i+1, i);
                        sorted = false;
                    }
                }
            }
        }
    }
}
