package io.github.generallyspecific.nba_application.model;

import jakarta.persistence.*;

@Entity
@Table(name="players")
@IdClass(PlayersIdKey.class)
public class Players {

    private String playerName;

    @Id
    private int teamId;

    @Id
    private int playerId;

    @Id
    private int season;

    @GeneratedValue(strategy = GenerationType.AUTO)

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Players{" +
                "playerName='" + playerName + '\'' +
                ", teamId=" + teamId +
                ", playerId=" + playerId +
                ", season=" + season +
                '}';
    }

    public Players() {
    }

    public Players(String playerName, int teamId, int playerId, int season) {
        this.playerName = playerName;
        this.teamId = teamId;
        this.playerId = playerId;
        this.season = season;
    }
}