package io.github.generallyspecific.nba_application.rankings;

public class RankingInput {
    private String team_id;
    private String season_id;
    private String standings_date;
    private String conference;
    private String team;
    private String g;
    private String w;
    private String l;
    private String w_pct;
    private String home_record;
    private String road_record;

    public RankingInput() {
    }

    public RankingInput(String team_id, String season_id, String standings_date, String conference, String team, String g, String w, String l, String w_pct, String home_record, String road_record) {
        this.team_id = team_id;
        this.season_id = season_id;
        this.standings_date = standings_date;
        this.conference = conference;
        this.team = team;
        this.g = g;
        this.w = w;
        this.l = l;
        this.w_pct = w_pct;
        this.home_record = home_record;
        this.road_record = road_record;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getSeason_id() {
        return season_id;
    }

    public void setSeason_id(String season_id) {
        this.season_id = season_id;
    }

    public String getStandings_date() {
        return standings_date;
    }

    public void setStandings_date(String standings_date) {
        this.standings_date = standings_date;
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

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getL() {
        return l;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getW_pct() {
        return w_pct;
    }

    public void setW_pct(String w_pct) {
        this.w_pct = w_pct;
    }

    public String getHome_record() {
        return home_record;
    }

    public void setHome_record(String home_record) {
        this.home_record = home_record;
    }

    public String getRoad_record() {
        return road_record;
    }

    public void setRoad_record(String road_record) {
        this.road_record = road_record;
    }

    @Override
    public String toString() {
        return "RankingInput{" +
                "team_id='" + team_id + '\'' +
                ", season_id='" + season_id + '\'' +
                ", standings_date='" + standings_date + '\'' +
                ", conference='" + conference + '\'' +
                ", team='" + team + '\'' +
                ", g='" + g + '\'' +
                ", w='" + w + '\'' +
                ", l='" + l + '\'' +
                ", w_pct='" + w_pct + '\'' +
                ", home_record='" + home_record + '\'' +
                ", road_record='" + road_record + '\'' +
                '}';
    }
}
