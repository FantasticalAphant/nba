import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import {PlayersPage} from "./pages/PlayersPage";
import {TeamsPage} from "./pages/TeamsPage";
import {IndividualGamePage} from "./pages/IndividualGamePage";
import {HomePage} from "./pages/HomePage";
import 'bootstrap/dist/css/bootstrap.min.css';
import * as React from "react";

import { ChakraProvider } from "@chakra-ui/react"
import {GamesFilterPage} from "./pages/GamesFilterPage";
import {PlayerSearchPage} from "./pages/PlayerSearchPage";

function App() {
    return (
        <ChakraProvider>
            <div className={"App"}>
                <Router>
                    <Routes>
                        <Route path={"/player/:playerName"} element={<PlayersPage/>}/>
                        <Route path={"/team/id/:teamId"} element={<TeamsPage/>}/>
                        <Route path={"/gamesdetails/game/:gameId"} element={<IndividualGamePage/>}/>
                        <Route path={"/"} element={<HomePage/>}/>
                        <Route path={"/calendar"} element={<GamesFilterPage/>} />
                        <Route path={"/players"} element={<PlayerSearchPage/>}/>
                    </Routes>
                </Router>
            </div>
        </ChakraProvider>
    );
}

export default App;
