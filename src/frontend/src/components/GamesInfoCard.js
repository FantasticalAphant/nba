// Displays basic information about a game

import {Link} from "react-router-dom";
import {Box, Divider, Heading} from "@chakra-ui/react";

function roundToTwo(num) {
    return Number(Math.round(num + "e+2")  + "e-2") * 100;
}

export const GamesInfoCard = ({gameInfo}) => {
    const game = gameInfo["game"];
    const date = new Date(game["gameDateEST"])
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    const dateString = date.toLocaleDateString("en-US", options);

    return (
        <Box p={4} my={4} borderWidth={1} borderRadius="lg" overflow="hidden">
            <Heading size="lg">
                Game ID: <Link to={`/gamesdetails/game/${game["gameId"]}`}>{game["gameId"]}</Link>
            </Heading>
            <h4>{dateString}</h4>
            <Divider mt={2}/>
            <h5>{gameInfo["homeTeamName"]}: {game["ptsHome"]}; FG%: {roundToTwo(game["fgPctHome"])}; FT%: {roundToTwo(game["ftPctHome"])}; 3FG%: {roundToTwo(game["fg3PctHome"])}</h5>
            <h5>{gameInfo["visitorTeamName"]}: {game["ptsAway"]}; FG%: {roundToTwo(game["fgPctAway"])}; FT%: {roundToTwo(game["ftPctAway"])}; 3FG%: {roundToTwo(game["fg3PctAway"])}</h5>
        </Box>
    );
}
