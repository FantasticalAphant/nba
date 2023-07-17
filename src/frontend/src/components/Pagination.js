// Source: https://www.youtube.com/watch?v=IYCa1F-OWmk

export const Pagination = ({gamesPerPage, totalGames, paginate}) => {
    const pageNumbers = [];

    for (let i = 1; i <= Math.ceil(totalGames / gamesPerPage); i++) {
        pageNumbers.push(i);
    }

    return (
        <nav>
            <ul className={"pagination"}>
                {pageNumbers.map(number => (
                    <li key={number} className={"page-item"}>
                        <button onClick={() => paginate(number)} className={"page-link"}>
                            {number}
                        </button>
                    </li>
                ))}
            </ul>
        </nav>
    );
}
