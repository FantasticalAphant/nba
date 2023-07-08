// Displays in-depth information about a game
import {styled} from "styled-components";
import {Link} from "react-router-dom";

const Ul = styled.ul`
    list-style-type: none;
`;

export const GamesSmallCard = ({games, loading}) => {
    if (loading) {
        // or maybe put spinner here
        return <h2>Loading...</h2>;
    }

    return (
        <Ul>
            {games.map((game, i) => (
                <li key={i}>
                    <Link to={`/gamesdetails/game/${game["gameId"]}`}>MIN: {game["min"]} | PTS: {game["pts"]} | REB: {game["reb"]} | AST: {game["ast"]} | +/-: {game["plusMinus"]}</Link>
                </li>
            ))}
        </Ul>
    );
}
