package io.github.generallyspecific.nba_application.data;

public class TeamsInput {
    private String team_id;
    private String min_year;
    private String max_year;
    private String abbreviation;
    private String nickname;
    private String year_founded;
    private String city;
    private String arena;
    private String owner;
    private String general_manager;
    private String head_coach;

    public TeamsInput() {
    }

    public TeamsInput(String team_id, String min_year, String max_year, String abbreviation, String nickname, String year_founded, String city, String arena, String arena_capacity, String owner, String general_manager, String head_coach) {
        this.team_id = team_id;
        this.min_year = min_year;
        this.max_year = max_year;
        this.abbreviation = abbreviation;
        this.nickname = nickname;
        this.year_founded = year_founded;
        this.city = city;
        this.arena = arena;
        this.owner = owner;
        this.general_manager = general_manager;
        this.head_coach = head_coach;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getMin_year() {
        return min_year;
    }

    public void setMin_year(String min_year) {
        this.min_year = min_year;
    }

    public String getMax_year() {
        return max_year;
    }

    public void setMax_year(String max_year) {
        this.max_year = max_year;
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

    public String getYear_founded() {
        return year_founded;
    }

    public void setYear_founded(String year_founded) {
        this.year_founded = year_founded;
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

    public String getGeneral_manager() {
        return general_manager;
    }

    public void setGeneral_manager(String general_manager) {
        this.general_manager = general_manager;
    }

    public String getHead_coach() {
        return head_coach;
    }

    public void setHead_coach(String head_coach) {
        this.head_coach = head_coach;
    }

    @Override
    public String toString() {
        return "TeamsInput{" +
                "team_id='" + team_id + '\'' +
                ", min_year='" + min_year + '\'' +
                ", max_year='" + max_year + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", nickname='" + nickname + '\'' +
                ", year_founded='" + year_founded + '\'' +
                ", city='" + city + '\'' +
                ", arena='" + arena + '\'' +
                ", owner='" + owner + '\'' +
                ", general_manager='" + general_manager + '\'' +
                ", head_coach='" + head_coach + '\'' +
                '}';
    }
}