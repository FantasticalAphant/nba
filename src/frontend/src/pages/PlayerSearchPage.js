import {NavigationBar} from "../components/NavigationBar";
import {useEffect, useState} from "react";
import {Input} from "@chakra-ui/react";
import {PlayerCard} from "../components/PlayerCard";

export const PlayerSearchPage = () => {
    const [query, setQuery] = useState("");
    const [results, setResults] = useState([]);

    const handleInputChange = (event) => {
        setQuery(event.target.value);
    }

    useEffect(() => {
        const fetchPlayers = async () => {
            if (query.length >= 3) {
                const response = await fetch(`http://localhost:8080/players/search?query=${query}`);
                const data = await response.json();
                setResults(data);
            } else {
                setResults([]);
            }
        };
        fetchPlayers();
    }, [query])

    return (
        <div>
            <NavigationBar />
            <Input placeholder="Search for a player" onChange={handleInputChange}/>
            {results.map((player, i) => <PlayerCard player={player} key={i}/>)}
        </div>
    )
}