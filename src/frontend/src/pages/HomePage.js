// Home page displaying all teams

import {useEffect, useState} from "react";
import {TeamCard} from "../components/TeamCard";
import {styled} from "styled-components";
import {NavigationBar} from "../components/NavigationBar";

const Page = styled.div`
`;

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
        <Page>
            <NavigationBar />
            <TeamLayout>
                {teams.map((team, i) => <TeamCard team={team} key={i}/>)}
            </TeamLayout>
        </Page>
    );
}
