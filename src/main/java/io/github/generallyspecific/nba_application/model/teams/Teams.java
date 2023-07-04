package io.github.generallyspecific.nba_application.model.teams;

import jakarta.persistence.*;

@Entity
@Table(name="teams")
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="team_id")
    private long teamId;
    @Column(name="min_year")
    private int minYear;
    @Column(name="max_year")
    private int maxYear;
    @Column(name="abbreviation")
    private String abbreviation;
    @Column(name="nickname")
    private String nickname;
    @Column(name="year_founded")
    private int yearFounded;
    @Column(name="city")
    private String city;
    @Column(name="arena")
    private String arena;
    @Column(name="owner")
    private String owner;
    @Column(name="generalManager")
    private String generalManager;
    @Column(name="head_coach")
    private String headCoach;

    public Teams() {
    }

    public Teams(long team_id, String nickname, String city) {
        this.teamId = team_id;
        this.nickname = nickname;
        this.city = city;
    }

    public Teams(long teamId, int minYear, int maxYear, String abbreviation, String nickname, int yearFounded, String city, String arena, String owner, String generalManager, String headCoach) {
        this.teamId = teamId;
        this.minYear = minYear;
        this.maxYear = maxYear;
        this.abbreviation = abbreviation;
        this.nickname = nickname;
        this.yearFounded = yearFounded;
        this.city = city;
        this.arena = arena;
        this.owner = owner;
        this.generalManager = generalManager;
        this.headCoach = headCoach;
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {
        this.teamId = teamId;
    }

    public int getMinYear() {
        return minYear;
    }

    public void setMinYear(int minYear) {
        this.minYear = minYear;
    }

    public int getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(int maxYear) {
        this.maxYear = maxYear;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArena() {
        return arena;
    }

    public void setArena(String arena) {
        this.arena = arena;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public void setGeneralManager(String generalManager) {
        this.generalManager = generalManager;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public void setHeadCoach(String headCoach) {
        this.headCoach = headCoach;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "teamId='" + teamId + '\'' +
                ", minYear=" + minYear +
                ", maxYear=" + maxYear +
                ", abbreviation='" + abbreviation + '\'' +
                ", nickname='" + nickname + '\'' +
                ", yearFounded=" + yearFounded +
                ", city='" + city + '\'' +
                ", arena='" + arena + '\'' +
                ", owner='" + owner + '\'' +
                ", generalManager='" + generalManager + '\'' +
                ", headCoach='" + headCoach + '\'' +
                '}';
    }
}
