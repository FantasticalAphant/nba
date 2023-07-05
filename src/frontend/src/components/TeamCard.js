import {styled} from "styled-components";
import {Link} from "react-router-dom";

const Card = styled.h3`
  font-size: 1.5em;
  text-align: center;
`;

export const TeamCard = ({team}) => {
    if (!team) return null;

    return (
        <div className={"GamesSmallCard"}>
            <Link to={`/team/${team.nickname}`}>
                <Card>
                    {team.city} {team.nickname} ({team.abbreviation})
                </Card>
            </Link>
        </div>
    );
}
