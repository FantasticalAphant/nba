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

    // TODO: group by team
    // TODO: add a link to the team page
    // TODO: display team names on the top
    // TODO: for each team, group by some order with those not playing at the bottom

    return (
        <Layout>
            {game.map((game, i) => (
                <Card>
                    {/*FIXME: for some reason, minutes are returning negative values*/}
                    <Link to={`/player/${game["playerName"]}`}>{game["playerName"]}</Link> ({game["teamAbbreviation"]}) - MIN: {game["min"]} | PTS: {game["pts"]} | {game["fgm"]}/{game["fga"]} FG | REB: {game["reb"]} | AST: {game["ast"]} | +/-: {game["plusMinus"]}
                </Card>
            ))}
        </Layout>
    );
}