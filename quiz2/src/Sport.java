import java.util.ArrayList;

public class Sport {
    public String team_name;
    public int games_won;
    public int games_tie;
    public int games_lost;
    public int sets_won;
    public int sets_lost;
    public int points;

    public Sport(String team_name, int games_won, int games_tie, int games_lost, int sets_won, int sets_lost, int points) {
        this.team_name = team_name;
        this.games_won = games_won;
        this.games_tie = games_tie;
        this.games_lost = games_lost;
        this.sets_won = sets_won;
        this.sets_lost = sets_lost;
        this.points = points;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public int getGames_won() {
        return games_won;
    }

    public void setGames_won(int games_won) {
        this.games_won = games_won;
    }

    public void addGames_won(int value) {
        this.games_won = getGames_won() + value;
    }

    public int getGames_tie() {
        return games_tie;
    }

    public void addGames_tie(int value) {
        this.games_tie = getGames_tie() + value;
    }

    public void setGames_tie(int games_tie) {
        this.games_tie = games_tie;
    }

    public int getGames_lost() {
        return games_lost;
    }

    public void addGames_lost(int value) {
        this.games_lost = getGames_lost() + value;
    }

    public void setGames_lost(int games_lost) {
        this.games_lost = games_lost;
    }

    public int getSets_won() {
        return sets_won;
    }

    public void addSets_won(int value) {
        this.sets_won = getSets_won() + value;
    }

    public void setSets_won(int sets_won) {
        this.sets_won = sets_won;
    }

    public int getSets_lost() {
        return sets_lost;
    }

    public void addSets_lost(int value) {
        this.sets_lost = getSets_lost() + value;
    }


    public void setSets_lost(int sets_lost) {
        this.sets_lost = sets_lost;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int value) {
        this.points = getPoints() + value;
    }



}
