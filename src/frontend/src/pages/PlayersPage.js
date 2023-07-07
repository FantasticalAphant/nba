// Page displaying information for a specific player and some of their games
import {useEffect, useState} from "react";
import {GamesSmallCard} from "../components/GamesSmallCard";
import {useParams} from "react-router-dom";

export const PlayersPage = () => {
    const [players, setPlayers] = useState([]);
    const [gamesDetails, setGamesDetails] = useState([]);
    const {playerName} = useParams();

    useEffect(
        () => {
            const fetchPlayerAndMatches = async () => {
                const response = await fetch(`http://localhost:8080/player/${playerName}`);
                const data = await response.json();
                setPlayers(data);
                const response2 = await fetch(`http://localhost:8080/gamesdetails/${playerName}`);
                const data2 = await response2.json();
                setGamesDetails(data2);
            };
            fetchPlayerAndMatches();
        }, [playerName]
    )

    if (!players) return null;
    if (!gamesDetails) return null;

    return (
        <div className={"PlayersPage"}>
            <h1>{players.playerName}</h1>
            <h3>
                {/*this operation is pretty slow though (db bottleneck)*/}
                {gamesDetails.slice(0, 10).map((game, i) => <GamesSmallCard game={game} key={i}/>)}
            </h3>
        </div>
    );
}
