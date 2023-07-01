package io.github.generallyspecific.nba_application.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ranking")
public class Ranking {
    @Id
    @Column(name="team_id")
    private int teamId;

    @Id
    @Column(name="season_id")
    private short seasonId;

    @Id
    @Column(name="standings_date")
    private LocalDate standingsDate;
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name="conference")
    private String conference;
    @Column(name="team")
    private String team;
    @Column(name="g")
    private byte g;
    @Column(name="w")
    private byte w;
    @Column(name="l")
    private byte l;
    @Column(name="w_pct")
    private double wPct;
    @Column(name="home_record")
    private String homeRecord;
    @Column(name="road_record")
    private String roadRecord;

    public Ranking() {
    }

    public Ranking(int teamId, short seasonId, byte w, byte l) {
        this.teamId = teamId;
        this.seasonId = seasonId;
        this.w = w;
        this.l = l;
    }

    public Ranking(int teamId, short seasonId, LocalDate standingsDate, String conference, String team, byte g, byte w, byte l, double wPct, String homeRecord, String roadRecord) {
        this.teamId = teamId;
        this.seasonId = seasonId;
        this.standingsDate = standingsDate;
        this.conference = conference;
        this.team = team;
        this.g = g;
        this.w = w;
        this.l = l;
        this.wPct = wPct;
        this.homeRecord = homeRecord;
        this.roadRecord = roadRecord;
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

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public byte getG() {
        return g;
    }

    public void setG(byte g) {
        this.g = g;
    }

    public byte getW() {
        return w;
    }

    public void setW(byte w) {
        this.w = w;
    }

    public byte getL() {
        return l;
    }

    public void setL(byte l) {
        this.l = l;
    }

    public double getwPct() {
        return wPct;
    }

    public void setwPct(double wPct) {
        this.wPct = wPct;
    }

    public String getHomeRecord() {
        return homeRecord;
    }

    public void setHomeRecord(String homeRecord) {
        this.homeRecord = homeRecord;
    }

    public String getRoadRecord() {
        return roadRecord;
    }

    public void setRoadRecord(String roadRecord) {
        this.roadRecord = roadRecord;
    }

    @Override
    public String toString() {
        return "Ranking{" +
                "teamId=" + teamId +
                ", seasonId=" + seasonId +
                ", standingsDate=" + standingsDate +
                ", conference='" + conference + '\'' +
                ", team='" + team + '\'' +
                ", g=" + g +
                ", w=" + w +
                ", l=" + l +
                ", wPct=" + wPct +
                ", homeRecord='" + homeRecord + '\'' +
                ", roadRecord='" + roadRecord + '\'' +
                '}';
    }
}
