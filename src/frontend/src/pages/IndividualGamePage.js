// Page displaying information for a specific game given a game ID

import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {NavigationBar} from "../components/NavigationBar";
import {Table, TableContainer, Tbody, Td, Th, Thead, Tr} from "@chakra-ui/react";

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
        <div>
            <NavigationBar />
            <TableContainer>
                <Table variant={"simple"}>
                    <Thead>
                        <Tr>
                            <Th>Player (Team)</Th>
                            <Th>MIN</Th>
                            <Th>PTS</Th>
                            <Th>FG</Th>
                            <Th>REB</Th>
                            <Th>AST</Th>
                            <Th>+/-</Th>
                        </Tr>
                    </Thead>
                    <Tbody>
                        {game.map((game, i) => {
                            const minutes = game["min"];
                            const absent = "DNP";
                            return (<Tr>
                                    <Td>
                                        <Link to={`/player/${game["playerName"]}`}>
                                            {game["playerName"]} ({game["teamAbbreviation"]})
                                        </Link>
                                    </Td>
                                    <Td>{minutes ? game["min"] : absent}</Td>
                                    <Td>{minutes ? game["pts"] : absent}</Td>
                                    <Td>{minutes ? (game["fgm"] + "/" + game["fga"]) : absent}</Td>
                                    <Td>{minutes ? game["ast"] : absent}</Td>
                                    <Td>{minutes ? game["reb"] : absent}</Td>
                                    <Td>{minutes ? game["plusMinus"] : absent}</Td>
                                </Tr>
                            )})}
                    </Tbody>
                </Table>
            </TableContainer>
        </div>
    );
}