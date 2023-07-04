import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";

export const IndividualGamePage = () => {
    const [game, setGame] = useState([]);
    const {gameId} = useParams();

    useEffect(
        () => {
            const fetchGameById = async () => {
                const response = await fetch(`http://localhost:8080/game/${gameId}`);
                const data = await response.json();
                setGame(data);
            };
            fetchGameById();
        }, [gameId]
    )

    return (
        <div className={"IndividualGamePage"}>
            <h2>{game.gameDateEST}</h2>
        </div>
    );
}