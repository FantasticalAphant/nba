// Page displaying information for a specific player and some of their games
import {useEffect, useState} from "react";
import {GamesSmallCard} from "../components/GamesSmallCard";
import {useParams} from "react-router-dom";
import {Pagination} from "../components/Pagination";

export const PlayersPage = () => {
    const [players, setPlayers] = useState([]);
    const [gamesDetails, setGamesDetails] = useState([]);
    const {playerName} = useParams();

    const [games, setGames] = useState([]);
    const [loading, setLoading] = useState(false);
    const [currentPage, setCurrentPage] = useState(1);
    const [gamesPerPage] = useState(25);

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
            <h1>{players.playerName}</h1>
            <h3>
                {/*this operation is pretty slow though (db bottleneck)*/}
                <GamesSmallCard games={currentGames} loading={loading}></GamesSmallCard>
                <Pagination gamesPerPage={gamesPerPage} totalGames={games.length} paginate={paginate}></Pagination>
            </h3>
        </div>
    );
}
