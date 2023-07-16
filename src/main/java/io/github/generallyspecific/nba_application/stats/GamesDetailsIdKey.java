package io.github.generallyspecific.nba_application.stats;

import java.io.Serializable;

public class GamesDetailsIdKey implements Serializable {
    private int gameId;
    private int playerId;

    public GamesDetailsIdKey() {
    }

    public GamesDetailsIdKey(int gameId, int playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "GamesDetailsIdKey{" +
                "gameId=" + gameId +
                ", playerId=" + playerId +
                '}';
    }
}
