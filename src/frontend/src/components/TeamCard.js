// Component displaying logo and name of a team (used on the home page)

import {styled} from "styled-components";
import {Link} from "react-router-dom";
import logos from "../images/importLogos";

const Card = styled.h3`
  font-size: 1.5em;
  text-align: center;
`;

// TODO: make images the same size (and maybe reposition everything?)

const Image = styled.img`
  width: 100%;
  height: auto;
  transform: scale(0.8);
`;

const Container = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100px;
  height: 100px;
`;

const CardContainer = styled.div`
  display: flex;
  justify-content: center;
  align-self: center;
  border: black solid 1px;
`;

export const TeamCard = ({team}) => {
    if (!team) return null;

    return (
        <CardContainer className={"GamesSmallCard"}>
            <Container>
            <Image src={`${logos[team.nickname.toLowerCase()]}`} alt={`${team.nickname} logo`}/>
            </Container>
            <Link to={`/team/id/${team.teamId}`}>  {/* Links to TeamsPage.js */}
                <Card>
                    {team.city} {team.nickname} ({team.abbreviation})
                </Card>
            </Link>
        </CardContainer>
    );
}
