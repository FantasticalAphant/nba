import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import {PlayersPage} from "./pages/PlayersPage";
import {TeamsPage} from "./pages/TeamsPage";
import {GamesPage} from "./pages/GamesPage";
import {IndividualGamePage} from "./pages/IndividualGamePage";
import {HomePage} from "./pages/HomePage";

function App() {
    return (
        <div className={"App"}>
            <Router>
                <Routes>
                    <Route path={"/player/:playerName"} element={<PlayersPage/>}/>
                    <Route path={"/team/id/:teamId"} element={<TeamsPage/>}/>
                    <Route path={"/games/:date"} element={<GamesPage/>}/>
                    <Route path={"/gamesdetails/game/:gameId"} element={<IndividualGamePage/>}/>
                    <Route path={"/"} element={<HomePage/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;
