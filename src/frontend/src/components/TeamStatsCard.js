// Component displaying team stats for a specific game

import {Link} from "react-router-dom";
import {
    AccordionButton,
    AccordionIcon,
    AccordionPanel,
    Box,
    Card,
    CardBody,
    CardHeader,
    Divider
} from "@chakra-ui/react";
import {AccordionItem} from "@chakra-ui/react";

function roundToTwo(num) {
    return Number(Math.round(num + "e+2")  + "e-2") * 100;
}

// This doesn't have all the stats like field goal / field goals made (calculate by summing up)

export const TeamStatsCard = ({id, gameInfo}) => {
    const game = gameInfo["game"];
    const date = new Date(game["gameDateEST"])
    const options = { year: 'numeric', month: 'long', day: 'numeric' };
    const dateString = date.toLocaleDateString("en-US", options);

    // home team === id && home team won -- green
    // home team === id && home team lost -- red
    // home team !== id && home team lost -- green
    // away team !== id && home team won -- red
    const cardColor = (id === game["homeTeamId"] && game["homeTeamWins"] === 1) || (id !== game["homeTeamId"] && game["homeTeamWins"] === 0) ? "green.100" : "red.100";

    return (
        <AccordionItem>
            {({ isExpanded }) => (
                <>
                    <h2>
                        <AccordionButton bg={isExpanded ? "white" : cardColor}>
                            <Box as={"span"} flex={"1"} textAlign={"right"}>
                                <h4>Game ID: {game["gameId"]}</h4>
                            </Box>
                            <AccordionIcon />
                        </AccordionButton>
                    </h2>
                    <AccordionPanel pb={4}>
                        <Card className={"TeamStatsCard"} size={"sm"} margin={"10px"} borderWidth={"2px"} borderColor={"gray.200"} bg={cardColor}>
                            <Box fontSize={"xs"}>
                                <CardHeader>
                                    <h3>Game ID: <Link to={`/gamesdetails/game/${game["gameId"]}`}>{game["gameId"]}</Link></h3>
                                    <h3>{dateString}</h3>
                                    {id === game["homeTeamId"] ? <h3>Home</h3> : <h3>Away</h3>}
                                </CardHeader>
                                <Divider />
                                <CardBody>
                                    <h2>{gameInfo["homeTeamName"]}: {game["ptsHome"]}; FG%: {roundToTwo(game["fgPctHome"])}; FT%: {roundToTwo(game["ftPctHome"])}; 3FG%: {roundToTwo(game["fg3PctHome"])} </h2>
                                    <h2>{gameInfo["visitorTeamName"]}: {game["ptsAway"]}; FG%: {roundToTwo(game["fgPctAway"])}; FT%: {roundToTwo(game["ftPctAway"])}; 3FG%: {roundToTwo(game["fg3PctAway"])} </h2>
                                </CardBody>
                            </Box>
                        </Card>
                    </AccordionPanel>
                </>
            )}
        </AccordionItem>
    );
}
// game_date_est,game_id,game_status_text,home_team_id,visitor_team_id,season,team_id_home,pts_home,fg_pct_home,ft_pct_home,fg3_pct_home,ast_home,reb_home,team_id_away,pts_away,fg_pct_away,ft_pct_away,fg3_pct_away,ast_away,reb_away,home_team_wins
