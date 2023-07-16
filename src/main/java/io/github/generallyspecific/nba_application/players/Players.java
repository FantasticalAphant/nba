package io.github.generallyspecific.nba_application.players;

import jakarta.persistence.*;

@Entity
@Table(name="players")
@IdClass(PlayersIdKey.class)
public class Players {

    @Column(name="player_name")
    private String playerName;

    @Id
    @Column(name="team_id")
    private int teamId;

    @Id
    @Column(name="player_id")
    private int playerId;

    @Id
    @Column(name="season")
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

    public Players(String playerName) {
        this.playerName = playerName;
    }

    public Players(String playerName, int teamId, int playerId, int season) {
        this.playerName = playerName;
        this.teamId = teamId;
        this.playerId = playerId;
        this.season = season;
    }
}