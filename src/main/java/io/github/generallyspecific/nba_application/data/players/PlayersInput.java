package io.github.generallyspecific.nba_application.data.players;

public class PlayersInput {
    private String player_name;
    private String team_id;
    private String player_id;
    private String season;

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "PlayersInput{" +
                "player_name='" + player_name + '\'' +
                ", team_id='" + team_id + '\'' +
                ", player_id='" + player_id + '\'' +
                ", season='" + season + '\'' +
                '}';
    }
}