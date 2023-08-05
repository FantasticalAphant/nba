// Page displaying information about a specific team

import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {TeamStatsCard} from "../components/TeamStatsCard";
import {NavigationBar} from "../components/NavigationBar";
import {Accordion, Center, Tab, TabList, TabPanel, TabPanels, Tabs, VStack} from '@chakra-ui/react'
import {RosterYearSelector} from "../components/RosterYearSelector";
import {TeamGamesYearSelector} from "../components/TeamGamesYearSelector";

export const TeamsPage = () => {
    const [team, setTeam] = useState([]);
    const {teamId} = useParams();
    const [selectedRosterYear, setSelectedRosterYear] = useState(2019);
    const [selectedGamesYear, setSelectedGamesYear] = useState(2022);

    const handleRosterYearChange = (year) => {
        setSelectedRosterYear(year);
    }

    const handleGamesYearChange = (year) => {
        console.log(`Year changed to ${year}`);
        setSelectedGamesYear(year);
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
                const response = await fetch(`http://localhost:8080/games/team/${teamId}/${selectedGamesYear}`);
                const data = await response.json();
                setGames(data);
            };
            fetchGames();
        }, [teamId, selectedGamesYear]
    )

    const [players, setPlayers] = useState([]);
    useEffect(
        () => {
            const fetchPlayers = async () => {
                const response = await fetch(`http://localhost:8080/players/${teamId}?season=${selectedRosterYear}`);
                const data = await response.json();
                setPlayers(data);
            };
            fetchPlayers();
        }, [teamId, selectedRosterYear]
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
                        <RosterYearSelector onYearChange={handleRosterYearChange}/>
                        {players.map((player, i) => <h3><Link to={`/player/${player["playerName"]}`}>{player["playerName"]}</Link></h3>)}
                    </TabPanel>
                    <TabPanel>
                        <TeamGamesYearSelector onYearChange={handleGamesYearChange}/>
                        <Accordion defaultIndex={[0, 1, 2, 3, 4]} allowMultiple>
                            {/*TODO: show all games*/}
                            {games.slice(0, 20).map((game, i) => <TeamStatsCard gameInfo={game} key={i}/>)}
                        </Accordion>
                    </TabPanel>
                </TabPanels>
            </Tabs>
        </div>
    );
}
