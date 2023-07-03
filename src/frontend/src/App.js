import './App.css';
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"
import {PlayersPage} from "./pages/PlayersPage";
import {GamesDetailsCard} from "./components/GamesDetailsCard";

function App() {
    return (
        <div className={"App"}>
            <Router>
                <Routes>
                    <Route path={"/player/:playerName"} element={<PlayersPage/>}/>
                </Routes>
            </Router>
            <GamesDetailsCard />
            <GamesDetailsCard />
        </div>
    );
}

export default App;
