// Source: https://www.youtube.com/watch?v=IYCa1F-OWmk

import {styled} from "styled-components";

const Ul = styled.ul`
    list-style-type: none;
`;

const Li = styled.li`
    display: inline-block;
`;

export const Pagination = ({gamesPerPage, totalGames, paginate}) => {
    const pageNumbers = [];

    for (let i = 1; i <= Math.ceil(totalGames / gamesPerPage); i++) {
        pageNumbers.push(i);
    }

    return (
        <nav>
            <Ul className={"pagination"}>
                {pageNumbers.map(number => (
                    <Li key={number} className={"page-item"}>
                        <button onClick={() => paginate(number)} className={"page-link"}>
                            {number}
                        </button>
                    </Li>
                ))}
            </Ul>
        </nav>
    );
}
