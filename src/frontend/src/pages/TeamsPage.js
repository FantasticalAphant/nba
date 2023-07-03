import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";

export const TeamsPage = () => {
    const [teams, setTeams] = useState([]);
    const {teamName} = useParams();

    useEffect(
        () => {
            const fetchTeam = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}`);
                const data = await response.json();
                setTeams(data);
            };
            fetchTeam();
        }, [teamName]
    )

    if (!teams) return null;

    return (
        <div className={"TeamsPage"}>
            <h3>{teams.city} {teams.nickname}</h3>
        </div>
    );
}
