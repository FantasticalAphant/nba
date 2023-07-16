// Home page displaying all teams

import {useEffect, useState} from "react";
import {TeamCard} from "../components/TeamCard";
import {NavigationBar} from "../components/NavigationBar";
import {Grid} from "@chakra-ui/react";
import {Link} from "react-router-dom";

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
            <NavigationBar />
            <Grid templateColumns={"repeat(6, 1fr)"} gap={"15px"}>
                {teams.map((team, i) => (
                    <Link to={`/team/id/${team["teamId"]}`}>  {/* Links to TeamsPage.js */}
                        <TeamCard team={team} key={i}/>
                    </Link>
                ))}
            </Grid>
        </div>
    );
}
