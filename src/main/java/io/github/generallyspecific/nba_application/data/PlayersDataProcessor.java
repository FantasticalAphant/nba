package io.github.generallyspecific.nba_application.data;

import io.github.generallyspecific.nba_application.model.Players;
import org.springframework.batch.item.ItemProcessor;

public class PlayersDataProcessor implements ItemProcessor<PlayersInput, Players> {

    @Override
    public Players process(final PlayersInput playersInput) throws Exception {
        Players player = new Players();

        player.setPlayerName(playersInput.getPlayer_name());
        player.setTeamId(Integer.parseInt(playersInput.getTeam_id()));
        player.setPlayerId(Integer.parseInt(playersInput.getPlayer_id()));
        player.setSeason(Integer.parseInt(playersInput.getSeason()));

        return player;
    }

}
