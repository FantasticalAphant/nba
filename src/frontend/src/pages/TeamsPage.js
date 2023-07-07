// Page displaying information about a specific team

import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {TeamStatsCard} from "../components/TeamStatsCard";
import {styled} from "styled-components";

const PageLayout = styled.div`
    display: grid;
    grid-template-columns: repeat(2, 1fr);
    grid-gap: 20px;
`;

const TeamName = styled.h1`
    font-size: 2em;
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

    // also print out the latest couple of games
    // also print out the players and ranking for a specified year
    if (!team) return null;
    if (!games) return null;

    // TODO: implement paging

    return (
        <PageLayout className={"TeamsPage"}>
            <TeamName>{team.city} {team.nickname} ({team.abbreviation})</TeamName>
            <div>
                {games.slice(0, 5).map((game, i) => <TeamStatsCard game={game} key={i}/>)}
            </div>
        </PageLayout>
    );
}
