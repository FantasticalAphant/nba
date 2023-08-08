import {Link} from "react-router-dom";

export const PlayerCard = ({player}) => {
    return (
        <div>
            <h1><Link to={`/player/${player["playerName"]}`} >{player["playerName"]}</Link> ({player["season"]})</h1>
        </div>
    )
}