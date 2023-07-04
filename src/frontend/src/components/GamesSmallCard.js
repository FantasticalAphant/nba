import {Link} from "react-router-dom";

export const GamesSmallCard = ({game}) => {
    if (!game) return null;

    return (
        <div className={"GamesSmallCard"}>
            <h3><Link to={`/game/${game.gameId}`}>Scoreline: {game.pts}/{game.reb}/{game.ast}</Link></h3>
        </div>
    );
}
