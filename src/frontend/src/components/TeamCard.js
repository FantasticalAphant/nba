// Component displaying logo and name of a team (used on the home page)

import {Link} from "react-router-dom";
import logos from "../images/importLogos";
import {Card, CardHeader, CardBody, CardFooter, Image, GridItem} from '@chakra-ui/react'

// TODO: make images the same size (and maybe reposition everything?)

export const TeamCard = ({team}) => {
    if (!team) return null;

    return (
        <Card size={"xs"} borderRadius={"lg"} paddingBottom={"4"}>
            <CardHeader display={"flex"} justifyContent={"center"} alignItems={"center"}>
                <Image src={`${logos[team["nickname"].toLowerCase()]}`}
                       alt={`${team["nickname"]} logo`}
                       transform={"scale(0.5)"}
                       width={"auto"}
                       height={"150px"}
                       borderRadius={"lg"}/>
            </CardHeader>
            <CardBody justifyContent={"center"} alignItems={"center"} textAlign={"center"}>
                <h3>
                    {team["city"]} {team["nickname"]} ({team["abbreviation"]})
                </h3>
            </CardBody>
        </Card>
    );
}
