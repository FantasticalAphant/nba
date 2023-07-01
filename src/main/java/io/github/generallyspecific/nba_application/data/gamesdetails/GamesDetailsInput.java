package io.github.generallyspecific.nba_application.data.gamesdetails;

public class GamesDetailsInput {
    private String game_id;
    private String team_id;
    private String team_abbreviation;
    private String team_city;
    private String player_id;
    private String player_name;
    private String nickname;
    private String start_position;
    private String comment;
    private String min;
    private String fgm;
    private String fga;
    private String fg_pct;
    private String fg3m;
    private String fg3a;
    private String fg3_pct;
    private String ftm;
    private String fta;
    private String ft_pct;
    private String oreb;
    private String dreb;
    private String reb;
    private String ast;
    private String stl;
    private String blk;
    private String to;
    private String pf;
    private String pts;
    private String plus_minus;

    public GamesDetailsInput() {
    }

    public GamesDetailsInput(String game_id, String team_id, String team_abbreviation, String team_city, String player_id, String player_name, String nickname, String start_position, String comment, String min, String fgm, String fga, String fg_pct, String fg3m, String fg3a, String fg3_pct, String ftm, String fta, String ft_pct, String oreb, String dreb, String reb, String ast, String stl, String blk, String to, String pf, String pts, String plus_minus) {
        this.game_id = game_id;
        this.team_id = team_id;
        this.team_abbreviation = team_abbreviation;
        this.team_city = team_city;
        this.player_id = player_id;
        this.player_name = player_name;
        this.nickname = nickname;
        this.start_position = start_position;
        this.comment = comment;
        this.min = min;
        this.fgm = fgm;
        this.fga = fga;
        this.fg_pct = fg_pct;
        this.fg3m = fg3m;
        this.fg3a = fg3a;
        this.fg3_pct = fg3_pct;
        this.ftm = ftm;
        this.fta = fta;
        this.ft_pct = ft_pct;
        this.oreb = oreb;
        this.dreb = dreb;
        this.reb = reb;
        this.ast = ast;
        this.stl = stl;
        this.blk = blk;
        this.to = to;
        this.pf = pf;
        this.pts = pts;
        this.plus_minus = plus_minus;
    }

    public String getGame_id() {
        return game_id;
    }

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    public String getTeam_abbreviation() {
        return team_abbreviation;
    }

    public void setTeam_abbreviation(String team_abbreviation) {
        this.team_abbreviation = team_abbreviation;
    }

    public String getTeam_city() {
        return team_city;
    }

    public void setTeam_city(String team_city) {
        this.team_city = team_city;
    }

    public String getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(String player_id) {
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStart_position() {
        return start_position;
    }

    public void setStart_position(String start_position) {
        this.start_position = start_position;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getFgm() {
        return fgm;
    }

    public void setFgm(String fgm) {
        this.fgm = fgm;
    }

    public String getFga() {
        return fga;
    }

    public void setFga(String fga) {
        this.fga = fga;
    }

    public String getFg_pct() {
        return fg_pct;
    }

    public void setFg_pct(String fg_pct) {
        this.fg_pct = fg_pct;
    }

    public String getFg3m() {
        return fg3m;
    }

    public void setFg3m(String fg3m) {
        this.fg3m = fg3m;
    }

    public String getFg3a() {
        return fg3a;
    }

    public void setFg3a(String fg3a) {
        this.fg3a = fg3a;
    }

    public String getFg3_pct() {
        return fg3_pct;
    }

    public void setFg3_pct(String fg3_pct) {
        this.fg3_pct = fg3_pct;
    }

    public String getFtm() {
        return ftm;
    }

    public void setFtm(String ftm) {
        this.ftm = ftm;
    }

    public String getFta() {
        return fta;
    }

    public void setFta(String fta) {
        this.fta = fta;
    }

    public String getFt_pct() {
        return ft_pct;
    }

    public void setFt_pct(String ft_pct) {
        this.ft_pct = ft_pct;
    }

    public String getOreb() {
        return oreb;
    }

    public void setOreb(String oreb) {
        this.oreb = oreb;
    }

    public String getDreb() {
        return dreb;
    }

    public void setDreb(String dreb) {
        this.dreb = dreb;
    }

    public String getReb() {
        return reb;
    }

    public void setReb(String reb) {
        this.reb = reb;
    }

    public String getAst() {
        return ast;
    }

    public void setAst(String ast) {
        this.ast = ast;
    }

    public String getStl() {
        return stl;
    }

    public void setStl(String stl) {
        this.stl = stl;
    }

    public String getBlk() {
        return blk;
    }

    public void setBlk(String blk) {
        this.blk = blk;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getPf() {
        return pf;
    }

    public void setPf(String pf) {
        this.pf = pf;
    }

    public String getPts() {
        return pts;
    }

    public void setPts(String pts) {
        this.pts = pts;
    }

    public String getPlus_minus() {
        return plus_minus;
    }

    public void setPlus_minus(String plus_minus) {
        this.plus_minus = plus_minus;
    }

    @Override
    public String toString() {
        return "GamesDetailsInput{" +
                "game_id='" + game_id + '\'' +
                ", team_id='" + team_id + '\'' +
                ", team_abbreviation='" + team_abbreviation + '\'' +
                ", team_city='" + team_city + '\'' +
                ", player_id='" + player_id + '\'' +
                ", player_name='" + player_name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", start_position='" + start_position + '\'' +
                ", comment='" + comment + '\'' +
                ", min='" + min + '\'' +
                ", fgm='" + fgm + '\'' +
                ", fga='" + fga + '\'' +
                ", fg_pct='" + fg_pct + '\'' +
                ", fg3m='" + fg3m + '\'' +
                ", fg3a='" + fg3a + '\'' +
                ", fg3_pct='" + fg3_pct + '\'' +
                ", ftm='" + ftm + '\'' +
                ", fta='" + fta + '\'' +
                ", ft_pct='" + ft_pct + '\'' +
                ", oreb='" + oreb + '\'' +
                ", dreb='" + dreb + '\'' +
                ", reb='" + reb + '\'' +
                ", ast='" + ast + '\'' +
                ", stl='" + stl + '\'' +
                ", blk='" + blk + '\'' +
                ", to='" + to + '\'' +
                ", pf='" + pf + '\'' +
                ", pts='" + pts + '\'' +
                ", plus_minus='" + plus_minus + '\'' +
                '}';
    }
}
