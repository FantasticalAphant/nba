// Page displaying information about a specific team

import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import {TeamStatsCard} from "../components/TeamStatsCard";
import {styled} from "styled-components";

const PageLayout = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  grid-gap: 20px;
`;

const RosterLayout = styled.div`
`;

const GamesLayout = styled.div`
`;

const TeamName = styled.h1`
  font-size: 3em;
`;

export const TeamsPage = () => {
    const [team, setTeam] = useState([]);
    const {teamId} = useParams();

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
                const response = await fetch(`http://localhost:8080/players/${teamId}/2019`);
                const data = await response.json();
                setPlayers(data);
            };
            fetchPlayers();
        }, [teamId]
    )

    // also print out the latest couple of games
    // also print out the players and ranking for a specified year
    if (!team) return null;
    if (!games) return null;
    if (!players) return null;

    // TODO: implement paging

    return (
        <div>
            <TeamName>{team.city} {team.nickname} ({team.abbreviation})</TeamName>
            <PageLayout>
                <RosterLayout>
                    {/*FIXME: update player spreadsheet to include rosters from 2019-2022*/}
                    <h1>Roster:</h1>
                    {players.map((player, i) => <h3><Link to={`/player/${player.playerName}`}>{player.playerName}</Link></h3>)}
                </RosterLayout>

                <GamesLayout>
                    <h1>Latest Games:</h1>
                    {games.slice(0, 5).map((game, i) => <TeamStatsCard game={game} key={i}/>)}
                </GamesLayout>
            </PageLayout>
        </div>
    );
}
