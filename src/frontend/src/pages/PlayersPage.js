import {useEffect, useState} from "react";
import {GamesSmallCard} from "../components/GamesSmallCard";

export const PlayersPage = () => {
    const [players, setPlayers] = useState([]);
    const [gamesDetails, setGamesDetails] = useState([]);

    useEffect(
        () => {
            const fetchPlayerAndMatches = async () => {
                const response = await fetch("http://localhost:8080/player/James Harden");
                const data = await response.json();
                setPlayers(data);
                const response2 = await fetch("http://localhost:8080/gamesdetails/James Harden");
                const data2 = await response2.json();
                setGamesDetails(data2);
            };
            fetchPlayerAndMatches();
        }, []
    )

    return (
        <div className={"PlayersPage"}>
            <h1>NBA</h1>
            <h3>{players.playerName}</h3>
            <h3>
                {/*this operations is pretty slow though (db bottleneck)*/}
                {gamesDetails.slice(1, 5).map((game, i) => <GamesSmallCard game={game} key={i}/>)}
            </h3>
        </div>
    );
}
