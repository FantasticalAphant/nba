package io.github.generallyspecific.nba_application.rankings;

import java.io.Serializable;
import java.time.LocalDate;

public class RankingIdKey implements Serializable {
    private int teamId;
    private short seasonId;
    LocalDate standingsDate;

    public RankingIdKey() {
    }

    public RankingIdKey(int teamId, short seasonId, LocalDate standingsDate) {
        this.teamId = teamId;
        this.seasonId = seasonId;
        this.standingsDate = standingsDate;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public short getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(short seasonId) {
        this.seasonId = seasonId;
    }

    public LocalDate getStandingsDate() {
        return standingsDate;
    }

    public void setStandingsDate(LocalDate standingsDate) {
        this.standingsDate = standingsDate;
    }

    @Override
    public String toString() {
        return "RankingIdKey{" +
                "teamId=" + teamId +
                ", seasonId=" + seasonId +
                ", standingsDate=" + standingsDate +
                '}';
    }
}
