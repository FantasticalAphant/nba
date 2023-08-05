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
    return +(Math.round(num + "e+2")  + "e-2");
}

// This doesn't have all the stats like field goal / field goals made (calculate by summing up)

export const TeamStatsCard = ({gameInfo}) => {
    const game = gameInfo["game"];
    return (
        <AccordionItem>
            <h2>
                <AccordionButton>
                    <Box as={"span"} flex={"1"} textAlign={"right"}>
                        <h4>Game ID: {game["gameId"]}</h4>
                    </Box>
                    <AccordionIcon />
                </AccordionButton>
            </h2>
            <AccordionPanel pb={4}>
                <Card className={"TeamStatsCard"} size={"sm"} margin={"10px"} borderWidth={"2px"} borderColor={"gray.200"}>
                    <Box fontSize={"xs"}>
                        <CardHeader>
                            <h3>Game ID: <Link to={`/gamesdetails/game/${game["gameId"]}`}>{game["gameId"]}</Link></h3>
                            <h3>{gameInfo["homeTeamName"]} vs {gameInfo["visitorTeamName"]}</h3>
                        </CardHeader>
                        <Divider />
                        <CardBody>
                            <h2>Home: {game["ptsHome"]}; FG%: {roundToTwo(game["fgPctHome"])}; FT%: {roundToTwo(game["ftPctHome"])}; 3FG%: {roundToTwo(game["fg3PctHome"])} </h2>
                            <h2>Away: {game["ptsAway"]}; FG%: {roundToTwo(game["fgPctAway"])}; FT%: {roundToTwo(game["ftPctAway"])}; 3FG%: {roundToTwo(game["fg3PctAway"])} </h2>
                        </CardBody>
                    </Box>
                </Card>
            </AccordionPanel>
        </AccordionItem>
    );
}
// game_date_est,game_id,game_status_text,home_team_id,visitor_team_id,season,team_id_home,pts_home,fg_pct_home,ft_pct_home,fg3_pct_home,ast_home,reb_home,team_id_away,pts_away,fg_pct_away,ft_pct_away,fg3_pct_away,ast_away,reb_away,home_team_wins
