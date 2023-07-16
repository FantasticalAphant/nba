package io.github.generallyspecific.nba_application.rankings;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class RankingController {
    private RankingRepository rankingRepository;

    public RankingController(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @GetMapping("/ranking/{standingsDate}")
    public List<Ranking> getRankingByStandingsDate(@PathVariable LocalDate standingsDate) {
        return this.rankingRepository.findRankingByStandingsDate(standingsDate);
    }
}