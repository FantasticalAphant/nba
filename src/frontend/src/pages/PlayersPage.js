// Page displaying information for a specific player and some of their games
import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {Pagination} from "../components/Pagination";
import {NavigationBar} from "../components/NavigationBar";
import {Center, Spinner, Table, TableContainer, Tbody, Td, Th, Thead, Tr} from "@chakra-ui/react";

export const PlayersPage = () => {
    const [players, setPlayers] = useState([]);
    const [gamesDetails, setGamesDetails] = useState([]);
    const {playerName} = useParams();

    const [games, setGames] = useState([]);
    const [loading, setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [gamesPerPage] = useState(50);

    useEffect(() => {
        const fetchGames = async () => {
            setLoading(true);
            const res = await fetch(`http://localhost:8080/gamesdetails/${playerName}`);
            const data = await res.json();
            setGames(data);
            setLoading(false);
        }
        fetchGames();
    }, [playerName]
    )

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

    const indexOfLastGame = currentPage * gamesPerPage;
    const indexOfFirstGame = indexOfLastGame - gamesPerPage;
    const currentGames = games.slice(indexOfFirstGame, indexOfLastGame);

    const paginate = (pageNumber) => setCurrentPage(pageNumber);

    return (
        <div className={"PlayersPage"}>
            <NavigationBar />
            <Center>
                <h1>{players["playerName"]}</h1>
            </Center>
            <Pagination gamesPerPage={gamesPerPage} totalGames={games.length} paginate={paginate}></Pagination>
            {loading ? (<Spinner />) : (
                <TableContainer>
                    <Table variant={"simple"}>
                        <Thead>
                            <Tr>
                                <Th>Game ID</Th>
                                <Th>Minutes</Th>
                                <Th>Points</Th>
                                <Th>Rebounds</Th>
                                <Th>Assists</Th>
                                <Th>+/-</Th>
                            </Tr>
                        </Thead>
                        <Tbody>
                            {currentGames.map((game, i) => {
                                const minutes = game["min"];
                                const absent = "DNP";
                                return (<Tr>
                                        <Td>
                                            <Link to={`/gamesdetails/game/${game["gameId"]}`}>{game["gameId"]}</Link>
                                        </Td>
                                        <Td>{minutes ? game["min"] : absent}</Td>
                                        <Td>{minutes ? game["pts"] : absent}</Td>
                                        <Td>{minutes ? game["ast"] : absent}</Td>
                                        <Td>{minutes ? game["reb"] : absent}</Td>
                                        <Td>{minutes ? game["plusMinus"] : absent}</Td>
                                    </Tr>
                                )})}
                        </Tbody>
                    </Table>
                </TableContainer>
            )}
            <Pagination gamesPerPage={gamesPerPage} totalGames={games.length} paginate={paginate}></Pagination>
        </div>
    );
}
