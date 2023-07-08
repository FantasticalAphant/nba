// Page displaying all games for a specific date

import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {GamesInfoCard} from "../components/GamesInfoCard";
import {NavigationBar} from "../components/NavigationBar";

export const GamesPage = () => {
    const [games, setGames] = useState([]);
    const {date} = useParams();

    useEffect(
        () => {
            const fetchGamesByDate = async () => {
                const response = await fetch(`http://localhost:8080/games/${date}`);
                const data = await response.json();
                setGames(data);
            };
            fetchGamesByDate();
        }, [date]
    )

    if (!games) return null;

    return (
        <div className={"GamesPage"}>
            <NavigationBar />
            <h1>{date}</h1>
            {games.map((game, i) => <GamesInfoCard game={game} key={i}/>)}
        </div>
    );
}
