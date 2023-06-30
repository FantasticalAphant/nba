package io.github.generallyspecific.nba_application.model;

import java.io.Serializable;

public class PlayersIdKey implements Serializable {
    private int playerId;
    private int teamId;
    private int season;

    public PlayersIdKey() {
    }

    public PlayersIdKey(int playerId, int teamId, int season) {
        this.playerId = playerId;
        this.teamId = teamId;
        this.season = season;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "PlayersIdKey{" +
                "playerId=" + playerId +
                ", teamId=" + teamId +
                ", season=" + season +
                '}';
    }
}