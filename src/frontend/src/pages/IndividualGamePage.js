// Page displaying information for a specific game given a game ID

import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {styled} from "styled-components";

const Layout = styled.div`
  display: grid;
`;

const Card = styled.h3`
  border: papayawhip solid 1px;
`;

export const IndividualGamePage = () => {
    const [game, setGame] = useState([]);
    const {gameId} = useParams();

    useEffect(
        () => {
            const fetchGameById = async () => {
                const response = await fetch(`http://localhost:8080/gamesdetails/game/${gameId}`);
                const data = await response.json();
                setGame(data);
            };
            fetchGameById();
        }, [gameId]
    )

    return (
        <Layout>
            {game.map((game, i) => (
                <Card>
                    {game.playerName} ({game.teamAbbreviation}) - MIN: {game.min} | PTS: {game.pts} | {game.fgm}/{game.fga} FG | REB: {game.reb} | AST: {game.ast} | +/-: {game.plusMinus}
                </Card>
            ))}
        </Layout>
    );
}