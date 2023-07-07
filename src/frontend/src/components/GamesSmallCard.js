// Component displaying a player's stats for a specific game

import {Link} from "react-router-dom";

export const GamesSmallCard = ({game}) => {
    if (!game) return null;

    return (
        <div className={"GamesSmallCard"}>
            <h3><Link to={`/gamesdetails/game/${game.gameId}`}>MIN: {game.min} | PTS: {game.pts} | REB: {game.reb} | AST: {game.ast} | +/-: {game.plusMinus}</Link></h3>
        </div>
    );
}
