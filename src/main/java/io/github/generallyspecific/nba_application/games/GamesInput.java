package io.github.generallyspecific.nba_application.games;

public class GamesInput {
    private String game_date_est;
    private String game_id;
    private String game_status_text;
    private String home_team_id;
    private String visitor_team_id;
    private String season;
    private String team_id_home;
    private String pts_home;
    private String fg_pct_home;
    private String ft_pct_home;
    private String fg3_pct_home;
    private String ast_home;
    private String reb_home;
    private String team_id_away;
    private String pts_away;
    private String fg_pct_away;
    private String ft_pct_away;
    private String fg3_pct_away;
    private String ast_away;
    private String reb_away;
    private String home_team_wins;

    public GamesInput() {
    }

    public GamesInput(String game_date_est, String game_id, String game_status_text, String home_team_id, String visitor_team_id, String season, String team_id_home, String pts_home, String fg_pct_home, String ft_pct_home, String fg3_pct_home, String ast_home, String reb_home, String team_id_away, String pts_away, String fg_pct_away, String ft_pct_away, String fg3_pct_away, String ast_away, String reb_away, String home_team_wins) {
        this.game_date_est = game_date_est;
        this.game_id = game_id;
        this.game_status_text = game_status_text;
        this.home_team_id = home_team_id;
        this.visitor_team_id = visitor_team_id;
        this.season = season;
        this.team_id_home = team_id_home;
        this.pts_home = pts_home;
        this.fg_pct_home = fg_pct_home;
        this.ft_pct_home = ft_pct_home;
        this.fg3_pct_home = fg3_pct_home;
        this.ast_home = ast_home;
        this.reb_home = reb_home;
        this.team_id_away = team_id_away;
        this.pts_away = pts_away;
        this.fg_pct_away = fg_pct_away;
        this.ft_pct_away = ft_pct_away;
        this.fg3_pct_away = fg3_pct_away;
        this.ast_away = ast_away;
        this.reb_away = reb_away;
        this.home_team_wins = home_team_wins;
    }

    public String getGame_date_est() {
        return game_date_est;
    }

    public void setGame_date_est(String game_date_est) {
        this.game_date_est = game_date_est;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getGame_status_text() {
        return game_status_text;
    }

    public void setGame_status_text(String game_status_text) {
        this.game_status_text = game_status_text;
    }

    public String getHome_team_id() {
        return home_team_id;
    }

    public void setHome_team_id(String home_team_id) {
        this.home_team_id = home_team_id;
    }

    public String getVisitor_team_id() {
        return visitor_team_id;
    }

    public void setVisitor_team_id(String visitor_team_id) {
        this.visitor_team_id = visitor_team_id;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTeam_id_home() {
        return team_id_home;
    }

    public void setTeam_id_home(String team_id_home) {
        this.team_id_home = team_id_home;
    }

    public String getPts_home() {
        return pts_home;
    }

    public void setPts_home(String pts_home) {
        this.pts_home = pts_home;
    }

    public String getFg_pct_home() {
        return fg_pct_home;
    }

    public void setFg_pct_home(String fg_pct_home) {
        this.fg_pct_home = fg_pct_home;
    }

    public String getFt_pct_home() {
        return ft_pct_home;
    }

    public void setFt_pct_home(String ft_pct_home) {
        this.ft_pct_home = ft_pct_home;
    }

    public String getFg3_pct_home() {
        return fg3_pct_home;
    }

    public void setFg3_pct_home(String fg3_pct_home) {
        this.fg3_pct_home = fg3_pct_home;
    }

    public String getAst_home() {
        return ast_home;
    }

    public void setAst_home(String ast_home) {
        this.ast_home = ast_home;
    }

    public String getReb_home() {
        return reb_home;
    }

    public void setReb_home(String reb_home) {
        this.reb_home = reb_home;
    }

    public String getTeam_id_away() {
        return team_id_away;
    }

    public void setTeam_id_away(String team_id_away) {
        this.team_id_away = team_id_away;
    }

    public String getPts_away() {
        return pts_away;
    }

    public void setPts_away(String pts_away) {
        this.pts_away = pts_away;
    }

    public String getFg_pct_away() {
        return fg_pct_away;
    }

    public void setFg_pct_away(String fg_pct_away) {
        this.fg_pct_away = fg_pct_away;
    }

    public String getFt_pct_away() {
        return ft_pct_away;
    }

    public void setFt_pct_away(String ft_pct_away) {
        this.ft_pct_away = ft_pct_away;
    }

    public String getFg3_pct_away() {
        return fg3_pct_away;
    }

    public void setFg3_pct_away(String fg3_pct_away) {
        this.fg3_pct_away = fg3_pct_away;
    }

    public String getAst_away() {
        return ast_away;
    }

    public void setAst_away(String ast_away) {
        this.ast_away = ast_away;
    }

    public String getReb_away() {
        return reb_away;
    }

    public void setReb_away(String reb_away) {
        this.reb_away = reb_away;
    }

    public String getHome_team_wins() {
        return home_team_wins;
    }

    public void setHome_team_wins(String home_team_wins) {
        this.home_team_wins = home_team_wins;
    }

    @Override
    public String toString() {
        return "GamesInput{" +
                "game_date_est='" + game_date_est + '\'' +
                ", game_id='" + game_id + '\'' +
                ", game_status_text='" + game_status_text + '\'' +
                ", home_team_id='" + home_team_id + '\'' +
                ", visitor_team_id='" + visitor_team_id + '\'' +
                ", season='" + season + '\'' +
                ", team_id_home='" + team_id_home + '\'' +
                ", pts_home='" + pts_home + '\'' +
                ", fg_pct_home='" + fg_pct_home + '\'' +
                ", ft_pct_home='" + ft_pct_home + '\'' +
                ", fg3_pct_home='" + fg3_pct_home + '\'' +
                ", ast_home='" + ast_home + '\'' +
                ", reb_home='" + reb_home + '\'' +
                ", team_id_away='" + team_id_away + '\'' +
                ", pts_away='" + pts_away + '\'' +
                ", fg_pct_away='" + fg_pct_away + '\'' +
                ", ft_pct_away='" + ft_pct_away + '\'' +
                ", fg3_pct_away='" + fg3_pct_away + '\'' +
                ", ast_away='" + ast_away + '\'' +
                ", reb_away='" + reb_away + '\'' +
                ", home_team_wins='" + home_team_wins + '\'' +
                '}';
    }
}
