// Page displaying information about a specific team

import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {TeamStatsCard} from "../components/TeamStatsCard";
import {NavigationBar} from "../components/NavigationBar";
import {Accordion, Center, Tab, TabList, TabPanel, TabPanels, Tabs, VStack} from '@chakra-ui/react'
import {YearSelector} from "../components/YearSelector";

export const TeamsPage = () => {
    const [team, setTeam] = useState([]);
    const {teamId} = useParams();
    const [selectedYear, setSelectedYear] = useState(2019);

    const handleYearChange = (year) => {
        console.log(`Year changed to ${year}`);
        setSelectedYear(year);
    }

    useEffect(
        () => {
            const fetchTeam = async () => {
                const response = await fetch(`http://localhost:8080/team/id/${teamId}`);
                const data = await response.json();

                setTeam(data);
            };
            fetchTeam();
        }, [teamId]
    )

    const [games, setGames] = useState([]);
    useEffect(
        () => {
            const fetchGames = async () => {
                const response = await fetch(`http://localhost:8080/games/team/${teamId}`);
                const data = await response.json();
                setGames(data);
            };
            fetchGames();
        }, [teamId]
    )

    const [players, setPlayers] = useState([]);
    useEffect(
        () => {
            const fetchPlayers = async () => {
                const response = await fetch(`http://localhost:8080/players/${teamId}?season=${selectedYear}`);
                const data = await response.json();
                setPlayers(data);
            };
            fetchPlayers();
        }, [teamId, selectedYear]
    )

    // also print out the latest couple of games
    // also print out the players and ranking for a specified year
    if (!team) return null;
    if (!games) return null;
    if (!players) return null;

    // TODO: implement paging
    // TODO: refactor into more components

    return (
        <div>
            <NavigationBar />
            <Center>
                <VStack>
                    <h1>{team["city"]} {team["nickname"]} ({team["abbreviation"]})</h1>
                    <YearSelector onYearChange={handleYearChange}/>
                </VStack>
            </Center>
            <Tabs variant={"enclosed"}>
                <TabList>
                    <Tab>Roster</Tab>
                    <Tab>Latest Games</Tab>
                </TabList>
                <TabPanels>
                    <TabPanel>
                        {/*FIXME: update player spreadsheet to include rosters from more years*/}
                        {players.map((player, i) => <h3><Link to={`/player/${player["playerName"]}`}>{player["playerName"]}</Link></h3>)}
                    </TabPanel>
                    <TabPanel>
                        <Accordion defaultIndex={[0, 1, 2, 3, 4]} allowMultiple>
                            {games.slice(0, 20).map((game, i) => <TeamStatsCard gameInfo={game} key={i}/>)}
                        </Accordion>
                    </TabPanel>
                </TabPanels>
            </Tabs>
        </div>
    );
}
