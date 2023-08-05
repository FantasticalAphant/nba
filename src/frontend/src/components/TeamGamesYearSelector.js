import {Box, Slider, SliderFilledTrack, SliderThumb, SliderTrack} from "@chakra-ui/react";
import {useState} from "react";

export const TeamGamesYearSelector = (props) => {
    const [year, setYear] = useState(2022);

    const handleYearChange = (value) => {
        setYear(value);
        props.onYearChange(value);
    }

    return (
        <Slider defaultValue={2022}
                min={2003}
                max={2022}
                step={1}
                onChange={handleYearChange}>
            <SliderTrack bg='red.100'>
                <Box position='relative' right={10} />
                <SliderFilledTrack bg='tomato' />
            </SliderTrack>
            <SliderThumb boxSize={5}>
                <Box position={"absolute"} top={"-20px"} d={"flex"} justifyContent={"center"} alignItems={"center"}>
                    {year}
                </Box>
            </SliderThumb>
        </Slider>
    )
}
