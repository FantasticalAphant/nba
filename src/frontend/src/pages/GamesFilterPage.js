import {NavigationBar} from "../components/NavigationBar";
import {GameDatePicker} from "../components/GameDatePicker";
import {useEffect, useState} from "react";
import {GamesInfoCard} from "../components/GamesInfoCard";

export const GamesFilterPage = () => {
    const [gamesDate, setGamesDate] = useState(new Date("2022-12-21"));
    const [games, setGames] = useState([]);

    const handleDateChange = (date) => {
        setGamesDate(date);
    }

    useEffect(
        () => {
            const fetchGamesByDate = async () => {
                const date = gamesDate.toISOString().split('T')[0];
                const response = await fetch(`http://localhost:8080/games/${date}`);
                const data = await response.json();
                setGames(data);
            };
            fetchGamesByDate();
        }, [gamesDate]
    )

    return (
        <div>
            <NavigationBar />
            <GameDatePicker onChange={handleDateChange}/>
            {games.length > 0 ?
                games.map((game, i) => <GamesInfoCard gameInfo={game} key={i}/>)
                :
                <h1>No game data available for this date</h1>
            }
        </div>
    )
}