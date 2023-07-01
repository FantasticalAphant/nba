package io.github.generallyspecific.nba_application.model;

import jakarta.persistence.*;

@Entity
@Table(name="games_details")
@IdClass(GamesDetailsIdKey.class)
public class GamesDetails {
    @Id
    @Column(name="game_id")
    private int gameId;
    @Column(name="team_id")
    private int teamId;
    @Column(name="team_abbreviation")
    private String teamAbbreviation;
    @Column(name="team_city")
    private String teamCity;
    @Id
    @Column(name="player_id")
    private int playerId;
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="player_name")
    private String playerName;
    @Column(name="nickname")
    private String nickname;
    @Column(name="start_position")
    private Character startPosition;
    @Column(name="comment")
    private String comment;
    @Column(name="min")
    private String min; // might change this to another format later
    @Column(name="fgm")
    private Byte fgm;
    @Column(name="fga")
    private Byte fga;
    @Column(name="fg_pct")
    private Double fgPct;
    @Column(name="fg3m")
    private Byte fg3m;
    @Column(name="fg3a")
    private Byte fg3a;
    @Column(name="fg3_pct")
    private Double fg3Pct;
    @Column(name="ftm")
    private Byte ftm;
    @Column(name="fta")
    private Byte fta;
    @Column(name="ft_pct")
    private Double ftPct;
    @Column(name="oreb")
    private Byte oreb;
    @Column(name="dreb")
    private Byte dreb;
    @Column(name="reb")
    private Byte reb;
    @Column(name="ast")
    private Byte ast;
    @Column(name="stl")
    private Byte stl;
    @Column(name="blk")
    private Byte blk;
    @Column(name="turnover")
    private Byte to;
    @Column(name="pf")
    private Byte pf;
    @Column(name="pts")
    private Byte pts;
    @Column(name="plus_minus")
    private Byte plusMinus;

    public GamesDetails() {
    }

    public GamesDetails(int gameId, int playerId, Byte plusMinus) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.plusMinus = plusMinus;
    }

    public GamesDetails(int gameId, int teamId, String teamAbbreviation, String teamCity, int playerId, String playerName, String nickname, Character startPosition, String comment, String min, Byte fgm, Byte fga, Double fgPct, Byte fg3m, Byte fg3a, Double fg3Pct, Byte ftm, Byte fta, Double ftPct, Byte oreb, Byte dreb, Byte reb, Byte ast, Byte stl, Byte blk, Byte to, Byte pf, Byte pts, Byte plusMinus) {
        this.gameId = gameId;
        this.teamId = teamId;
        this.teamAbbreviation = teamAbbreviation;
        this.teamCity = teamCity;
        this.playerId = playerId;
        this.playerName = playerName;
        this.nickname = nickname;
        this.startPosition = startPosition;
        this.comment = comment;
        this.min = min;
        this.fgm = fgm;
        this.fga = fga;
        this.fgPct = fgPct;
        this.fg3m = fg3m;
        this.fg3a = fg3a;
        this.fg3Pct = fg3Pct;
        this.ftm = ftm;
        this.fta = fta;
        this.ftPct = ftPct;
        this.oreb = oreb;
        this.dreb = dreb;
        this.reb = reb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.to = to;
        this.pf = pf;
        this.pts = pts;
        this.plusMinus = plusMinus;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamAbbreviation() {
        return teamAbbreviation;
    }

    public void setTeamAbbreviation(String teamAbbreviation) {
        this.teamAbbreviation = teamAbbreviation;
    }

    public String getTeamCity() {
        return teamCity;
    }

    public void setTeamCity(String teamCity) {
        this.teamCity = teamCity;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Character getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Character startPosition) {
        this.startPosition = startPosition;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public Byte getFgm() {
        return fgm;
    }

    public void setFgm(Byte fgm) {
        this.fgm = fgm;
    }

    public Byte getFga() {
        return fga;
    }

    public void setFga(Byte fga) {
        this.fga = fga;
    }

    public Double getFgPct() {
        return fgPct;
    }

    public void setFgPct(Double fgPct) {
        this.fgPct = fgPct;
    }

    public Byte getFg3m() {
        return fg3m;
    }

    public void setFg3m(Byte fg3m) {
        this.fg3m = fg3m;
    }

    public Byte getFg3a() {
        return fg3a;
    }

    public void setFg3a(Byte fg3a) {
        this.fg3a = fg3a;
    }

    public Double getFg3Pct() {
        return fg3Pct;
    }

    public void setFg3Pct(Double fg3Pct) {
        this.fg3Pct = fg3Pct;
    }

    public Byte getFtm() {
        return ftm;
    }

    public void setFtm(Byte ftm) {
        this.ftm = ftm;
    }

    public Byte getFta() {
        return fta;
    }

    public void setFta(Byte fta) {
        this.fta = fta;
    }

    public Double getFtPct() {
        return ftPct;
    }

    public void setFtPct(Double ftPct) {
        this.ftPct = ftPct;
    }

    public Byte getOreb() {
        return oreb;
    }

    public void setOreb(Byte oreb) {
        this.oreb = oreb;
    }

    public Byte getDreb() {
        return dreb;
    }

    public void setDreb(Byte dreb) {
        this.dreb = dreb;
    }

    public Byte getReb() {
        return reb;
    }

    public void setReb(Byte reb) {
        this.reb = reb;
    }

    public Byte getAst() {
        return ast;
    }

    public void setAst(Byte ast) {
        this.ast = ast;
    }

    public Byte getStl() {
        return stl;
    }

    public void setStl(Byte stl) {
        this.stl = stl;
    }

    public Byte getBlk() {
        return blk;
    }

    public void setBlk(Byte blk) {
        this.blk = blk;
    }

    public Byte getTo() {
        return to;
    }

    public void setTo(Byte to) {
        this.to = to;
    }

    public Byte getPf() {
        return pf;
    }

    public void setPf(Byte pf) {
        this.pf = pf;
    }

    public Byte getPts() {
        return pts;
    }

    public void setPts(Byte pts) {
        this.pts = pts;
    }

    public Byte getPlusMinus() {
        return plusMinus;
    }

    public void setPlusMinus(Byte plus_minus) {
        this.plusMinus = plus_minus;
    }

    @Override
    public String toString() {
        return "GamesDetails{" +
                "gameId=" + gameId +
                ", teamId=" + teamId +
                ", teamAbbreviation='" + teamAbbreviation + '\'' +
                ", teamCity='" + teamCity + '\'' +
                ", playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", startPosition=" + startPosition +
                ", comment='" + comment + '\'' +
                ", min='" + min + '\'' +
                ", fgm=" + fgm +
                ", fga=" + fga +
                ", fgPct=" + fgPct +
                ", fg3m=" + fg3m +
                ", fg3a=" + fg3a +
                ", fg3Pct=" + fg3Pct +
                ", ftm=" + ftm +
                ", fta=" + fta +
                ", ftPct=" + ftPct +
                ", oreb=" + oreb +
                ", dreb=" + dreb +
                ", reb=" + reb +
                ", ast=" + ast +
                ", stl=" + stl +
                ", blk=" + blk +
                ", to=" + to +
                ", pf=" + pf +
                ", pts=" + pts +
                ", plus_minus=" + plusMinus +
                '}';
    }
}
