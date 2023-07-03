import './App.css';
import {PlayersPage} from "./pages/PlayersPage";
import {GamesDetailsCard} from "./components/GamesDetailsCard";

function App() {
    return (
        <div className={"App"}>
            <PlayersPage />
            <GamesDetailsCard />
            <GamesDetailsCard />
            <GamesDetailsCard />
        </div>
    );
}

export default App;
