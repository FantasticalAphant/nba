package io.github.generallyspecific.nba_application.games;

public class GameInfoDTO {
    private Games game;
    private String homeTeamName;
    private String visitorTeamName;

    public GameInfoDTO() {
    }

    public GameInfoDTO(Games game, String homeTeamName, String visitorTeamName) {
        this.game = game;
        this.homeTeamName = homeTeamName;
        this.visitorTeamName = visitorTeamName;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public void setHomeTeamName(String homeTeamName) {
        this.homeTeamName = homeTeamName;
    }

    public String getVisitorTeamName() {
        return visitorTeamName;
    }

    public void setVisitorTeamName(String visitorTeamName) {
        this.visitorTeamName = visitorTeamName;
    }

    @Override
    public String toString() {
        return "GameInfoDTO{" +
                "game=" + game +
                ", homeTeamName='" + homeTeamName + '\'' +
                ", visitorTeamName='" + visitorTeamName + '\'' +
                '}';
    }
}
