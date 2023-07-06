function roundToTwo(num) {
    return +(Math.round(num + "e+2")  + "e-2");
}

export const TeamStatsCard = ({game}) => {
    return (
        <div className={"TeamStatsCard"}>
            <h3>Game ID: {game.gameID}</h3>
            <h2>Home: {game.ptsHome}; FG%: {roundToTwo(game.fgPctHome)}; FT%: {roundToTwo(game.ftPctHome)}; 3FG%: {roundToTwo(game.fg3PctHome)} </h2>
            <h2>Away: {game.ptsAway}; FG%: {roundToTwo(game.fgPctAway)}; FT%: {roundToTwo(game.ftPctAway)}; 3FG%: {roundToTwo(game.fg3PctAway)} </h2>
        </div>
    );
}
// game_date_est,game_id,game_status_text,home_team_id,visitor_team_id,season,team_id_home,pts_home,fg_pct_home,ft_pct_home,fg3_pct_home,ast_home,reb_home,team_id_away,pts_away,fg_pct_away,ft_pct_away,fg3_pct_away,ast_away,reb_away,home_team_wins
