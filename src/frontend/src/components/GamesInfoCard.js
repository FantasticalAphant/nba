export const GamesInfoCard = ({game}) => {
    if (!game) return null;
    return (
        <div className={"GamesInfoCard"}>
            <h3>{game.ptsHome} vs {game.ptsAway}</h3>
        </div>
    );
}
