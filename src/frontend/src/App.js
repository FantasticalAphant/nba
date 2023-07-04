import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import {PlayersPage} from "./pages/PlayersPage";
import {TeamsPage} from "./pages/TeamsPage";
import {GamesPage} from "./pages/GamesPage";
import {IndividualGamePage} from "./pages/IndividualGamePage";

function App() {
    return (
        <div className={"App"}>
            <Router>
                <Routes>
                    <Route path={"/player/:playerName"} element={<PlayersPage/>}/>
                    <Route path={"/team/:teamName"} element={<TeamsPage/>}/>
                    <Route path={"/games/:date"} element={<GamesPage/>}/>
                    <Route path={"/game/:gameId"} element={<IndividualGamePage/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;
