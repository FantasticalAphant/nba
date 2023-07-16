package io.github.generallyspecific.nba_application.games;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="games", indexes = {
        @Index(name="idx_games_game_date_est", columnList = "game_date_est"),
})
public class Games {

    @Column(name="game_date_est")
    private LocalDate gameDateEST;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="game_id")
    private int gameId;
    @Column(name="game_status_text")
    private String gameStatusText; // might use a boolean instead?
    @Column(name="home_team_id")
    private int homeTeamId;
    @Column(name="visitor_team_id")
    private int visitorTeamId;
    @Column(name="season")
    private short season;
    @Column(name="team_id_home")
    private int teamIdHome;
    @Column(name="pts_home")
    private short ptsHome;
    @Column(name="fg_pct_home")
    private double fgPctHome; // or convert it later for accuracy?
    @Column(name="ft_pct_home")
    private double ftPctHome;
    @Column(name="fg3_pct_home")
    private double fg3PctHome;
    @Column(name="ast_home")
    private byte astHome;
    @Column(name="reb_home")
    private byte rebHome;
    @Column(name="team_id_away")
    private int teamIdAway;
    @Column(name="pts_away")
    private short ptsAway;
    @Column(name="fg_pct_away")
    private double fgPctAway;
    @Column(name="ft_pct_away")
    private double ftPctAway;
    @Column(name="fg3_pct_away")
    private double fg3PctAway;
    @Column(name="ast_away")
    private byte astAway;
    @Column(name="reb_away")
    private byte rebAway;
    @Column(name="home_team_wins")
    private byte homeTeamWins;

    public Games() {
    }

    public Games(LocalDate gameDateEST, int gameId) {
        this.gameDateEST = gameDateEST;
        this.gameId = gameId;
    }

    public Games(LocalDate gameDateEST, int gameId, String gameStatusText, int homeTeamId, int visitorTeamId, short season, int teamIdHome, short ptsHome, double fgPctHome, double ftPctHome, double fg3PctHome, byte astHome, byte rebHome, int teamIdAway, short ptsAway, double fgPctAway, double ftPctAway, double fg3PctAway, byte astAway, byte rebAway, byte homeTeamWins) {
        this.gameDateEST = gameDateEST;
        this.gameId = gameId;
        this.gameStatusText = gameStatusText;
        this.homeTeamId = homeTeamId;
        this.visitorTeamId = visitorTeamId;
        this.season = season;
        this.teamIdHome = teamIdHome;
        this.ptsHome = ptsHome;
        this.fgPctHome = fgPctHome;
        this.ftPctHome = ftPctHome;
        this.fg3PctHome = fg3PctHome;
        this.astHome = astHome;
        this.rebHome = rebHome;
        this.teamIdAway = teamIdAway;
        this.ptsAway = ptsAway;
        this.fgPctAway = fgPctAway;
        this.ftPctAway = ftPctAway;
        this.fg3PctAway = fg3PctAway;
        this.astAway = astAway;
        this.rebAway = rebAway;
        this.homeTeamWins = homeTeamWins;
    }

    public LocalDate getGameDateEST() {
        return gameDateEST;
    }

    public void setGameDateEST(LocalDate gameDateEST) {
        this.gameDateEST = gameDateEST;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameStatusText() {
        return gameStatusText;
    }

    public void setGameStatusText(String gameStatusText) {
        this.gameStatusText = gameStatusText;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public int getVisitorTeamId() {
        return visitorTeamId;
    }

    public void setVisitorTeamId(int visitorTeamId) {
        this.visitorTeamId = visitorTeamId;
    }

    public short getSeason() {
        return season;
    }

    public void setSeason(short season) {
        this.season = season;
    }

    public int getTeamIdHome() {
        return teamIdHome;
    }

    public void setTeamIdHome(int teamIdHome) {
        this.teamIdHome = teamIdHome;
    }

    public short getPtsHome() {
        return ptsHome;
    }

    public void setPtsHome(short ptsHome) {
        this.ptsHome = ptsHome;
    }

    public double getFgPctHome() {
        return fgPctHome;
    }

    public void setFgPctHome(double fgPctHome) {
        this.fgPctHome = fgPctHome;
    }

    public double getFtPctHome() {
        return ftPctHome;
    }

    public void setFtPctHome(double ftPctHome) {
        this.ftPctHome = ftPctHome;
    }

    public double getFg3PctHome() {
        return fg3PctHome;
    }

    public void setFg3PctHome(double fg3PctHome) {
        this.fg3PctHome = fg3PctHome;
    }

    public byte getAstHome() {
        return astHome;
    }

    public void setAstHome(byte astHome) {
        this.astHome = astHome;
    }

    public byte getRebHome() {
        return rebHome;
    }

    public void setRebHome(byte rebHome) {
        this.rebHome = rebHome;
    }

    public int getTeamIdAway() {
        return teamIdAway;
    }

    public void setTeamIdAway(int teamIdAway) {
        this.teamIdAway = teamIdAway;
    }

    public short getPtsAway() {
        return ptsAway;
    }

    public void setPtsAway(short ptsAway) {
        this.ptsAway = ptsAway;
    }

    public double getFgPctAway() {
        return fgPctAway;
    }

    public void setFgPctAway(double fgPctAway) {
        this.fgPctAway = fgPctAway;
    }

    public double getFtPctAway() {
        return ftPctAway;
    }

    public void setFtPctAway(double ftPctAway) {
        this.ftPctAway = ftPctAway;
    }

    public double getFg3PctAway() {
        return fg3PctAway;
    }

    public void setFg3PctAway(double fg3PctAway) {
        this.fg3PctAway = fg3PctAway;
    }

    public byte getAstAway() {
        return astAway;
    }

    public void setAstAway(byte astAway) {
        this.astAway = astAway;
    }

    public byte getRebAway() {
        return rebAway;
    }

    public void setRebAway(byte rebAway) {
        this.rebAway = rebAway;
    }

    public byte getHomeTeamWins() {
        return homeTeamWins;
    }

    public void setHomeTeamWins(byte homeTeamWins) {
        this.homeTeamWins = homeTeamWins;
    }

    @Override
    public String toString() {
        return "Games{" +
                "gameDateEST=" + gameDateEST +
                ", gameId=" + gameId +
                ", gameStatusText='" + gameStatusText + '\'' +
                ", homeTeamId=" + homeTeamId +
                ", visitorTeamId=" + visitorTeamId +
                ", season=" + season +
                ", teamIdHome=" + teamIdHome +
                ", ptsHome=" + ptsHome +
                ", fgPctHome=" + fgPctHome +
                ", ftPctHome=" + ftPctHome +
                ", fg3PctHome=" + fg3PctHome +
                ", astHome=" + astHome +
                ", rebHome=" + rebHome +
                ", teamIdAway=" + teamIdAway +
                ", ptsAway=" + ptsAway +
                ", fgPctAway=" + fgPctAway +
                ", ftPctAway=" + ftPctAway +
                ", fg3PctAway=" + fg3PctAway +
                ", astAway=" + astAway +
                ", rebAway=" + rebAway +
                ", homeTeamWins=" + homeTeamWins +
                '}';
    }
}