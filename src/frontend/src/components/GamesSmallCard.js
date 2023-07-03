export const GamesSmallCard = ({game}) => {
    return (
        <div className={"GamesSmallCard"}>
            <h3>{game.pts}/{game.reb}/{game.ast}</h3>
        </div>
    );
}
