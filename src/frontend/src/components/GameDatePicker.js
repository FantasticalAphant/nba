import {useState} from "react";
import {Box, Input} from "@chakra-ui/react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export const GameDatePicker = ({onChange}) => {
    const [startDate, setStartDate] = useState(new Date("2022-12-21"));

    const handleDateChange = (date) => {
        setStartDate(date);
        if (onChange) {
            onChange(date);
        }
    }

    return (
        <Box>
            <DatePicker
                selected={startDate}
                onChange={handleDateChange}
                customInput={<Input />}
            />
        </Box>
    );
}