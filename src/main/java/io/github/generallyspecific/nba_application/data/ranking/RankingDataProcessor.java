package io.github.generallyspecific.nba_application.data.ranking;

import io.github.generallyspecific.nba_application.model.Ranking;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class RankingDataProcessor implements ItemProcessor<RankingInput, Ranking> {

    @Override
    public Ranking process(final RankingInput rankingInput) throws Exception {
        Ranking ranking = new Ranking();

        ranking.setTeamId(Integer.parseInt(rankingInput.getTeam_id()));
        ranking.setSeasonId(Short.parseShort(rankingInput.getSeason_id()));
        ranking.setStandingsDate(LocalDate.parse(rankingInput.getStandings_date()));
        ranking.setConference(rankingInput.getConference());
        ranking.setTeam(rankingInput.getTeam());
        ranking.setG(Byte.parseByte(rankingInput.getG()));
        ranking.setW(Byte.parseByte(rankingInput.getW()));
        ranking.setL(Byte.parseByte(rankingInput.getL()));
        ranking.setwPct(Double.parseDouble(rankingInput.getW_pct()));
        ranking.setHomeRecord(rankingInput.getHome_record());
        ranking.setRoadRecord(rankingInput.getRoad_record());

        return ranking;
    }

}
