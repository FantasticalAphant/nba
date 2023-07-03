export const GamesSmallCard = ({game}) => {
    if (!game) return null;
    return (
        <div className={"GamesSmallCard"}>
            <h3>Scoreline: {game.pts}/{game.reb}/{game.ast}</h3>
        </div>
    );
}
