import {useEffect, useState} from "react";
import {TeamCard} from "../components/TeamCard";
import {styled} from "styled-components";

const TeamLayout = styled.div`
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    grid-gap: 20px;
`;

export const HomePage = () => {
    const [teams, setTeams] = useState([]);

    useEffect(
        () => {
            const fetchTeams = async () => {
                const response = await fetch(`http://localhost:8080/teams`);
                const data = await response.json();
                setTeams(data);
            };
            fetchTeams();
        }, []
    )

    return (
        <div>
            <h1>NBA Information Board</h1>
            <TeamLayout>
                {teams.map((team, i) => <TeamCard team={team} key={i}/>)}
            </TeamLayout>
        </div>
    );
}
