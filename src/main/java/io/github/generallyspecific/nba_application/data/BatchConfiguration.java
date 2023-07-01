package io.github.generallyspecific.nba_application.data;

import io.github.generallyspecific.nba_application.data.games.GamesDataProcessor;
import io.github.generallyspecific.nba_application.data.games.GamesInput;
import io.github.generallyspecific.nba_application.data.gamesdetails.GamesDetailsDataProcessor;
import io.github.generallyspecific.nba_application.data.gamesdetails.GamesDetailsInput;
import io.github.generallyspecific.nba_application.data.players.PlayersDataProcessor;
import io.github.generallyspecific.nba_application.data.players.PlayersInput;
import io.github.generallyspecific.nba_application.data.ranking.RankingDataProcessor;
import io.github.generallyspecific.nba_application.data.ranking.RankingInput;
import io.github.generallyspecific.nba_application.data.teams.TeamsDataProcessor;
import io.github.generallyspecific.nba_application.data.teams.TeamsInput;
import io.github.generallyspecific.nba_application.model.*;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    private final String[] PLAYERS_FIELD_NAMES = new String[] {
            "player_name", "team_id", "player_id", "season"
    };

    private final String[] GAMES_FIELD_NAMES = new String[] {
            "game_date_est","game_id","game_status_text","home_team_id","visitor_team_id","season","team_id_home","pts_home","fg_pct_home","ft_pct_home","fg3_pct_home","ast_home","reb_home","team_id_away","pts_away","fg_pct_away","ft_pct_away","fg3_pct_away","ast_away","reb_away","home_team_wins"
    };

    private final String[] TEAMS_FIELD_NAMES = new String[] {
            "team_id", "min_year", "max_year", "abbreviation", "nickname", "year_founded", "city", "arena", "owner", "general_manager", "head_coach"
    };

    private final String[] RANKING_FIELD_NAMES = new String[] {
            "teamId", "seasonId", "standingsDate", "conference", "team", "g", "w", "l", "wPct", "homeRecord", "roadRecord"
    };

    private final String[] GAMES_DETAILS_FIELD_NAMES = new String[] {
            "game_id", "team_id", "team_abbreviation", "team_city", "player_id", "player_name", "nickname", "start_position", "comment", "min", "fgm", "fga", "fg_pct", "fg3m", "fg3a", "fg3_pct", "ftm", "fta", "ft_pct", "oreb", "dreb", "reb", "ast", "stl", "blk", "to", "pf", "pts", "plus_minus"
    };

    @Bean
    public FlatFileItemReader<GamesInput> reader() {
        return new FlatFileItemReaderBuilder<GamesInput>()
                .name("gamesItemReader")
                .resource(new ClassPathResource("csv/games.csv"))
                .linesToSkip(1)
                .delimited()
                .names(GAMES_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(GamesInput.class);
                }})
                .build();
    }

    @Bean
    public GamesDataProcessor processor() {
        return new GamesDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Games> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Games>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO games (game_date_est, game_id, game_status_text, home_team_id, visitor_team_id, season, team_id_home, pts_home, fg_pct_home, ft_pct_home, fg3_pct_home, ast_home, reb_home, team_id_away, pts_away, fg_pct_away, ft_pct_away, fg3_pct_away, ast_away, reb_away, home_team_wins)"
                        + " VALUES (:gameDateEST, :gameID, :gameStatusText, :homeTeamID, :visitorTeamID, :season, :teamIDHome, :ptsHome, :fgPctHome, :ftPctHome, :fg3PctHome, :astHome, :rebHome, :teamIDAway, :ptsAway, :fgPctAway, :ftPctAway, :fg3PctAway, :astAway, :rebAway, :homeTeamWins)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<PlayersInput> reader1() {
        return new FlatFileItemReaderBuilder<PlayersInput>()
                .name("playersItemReader")
                .resource(new ClassPathResource("csv/players.csv"))
                .linesToSkip(1)
                .delimited()
                .names(PLAYERS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayersInput>() {{
                    setTargetType(PlayersInput.class);
                }})
                .build();
    }

    @Bean
    public PlayersDataProcessor processor1() {
        return new PlayersDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Players> writer1(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Players>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO players (player_name, team_id, player_id, season)" +
                        " VALUES (:playerName, :teamId, :playerId, :season)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<TeamsInput> reader2() {
        return new FlatFileItemReaderBuilder<TeamsInput>()
                .name("teamsItemReader")
                .resource(new ClassPathResource("csv/teams_updated.csv"))
                .linesToSkip(1)
                .delimited()
                .names(TEAMS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(TeamsInput.class);
                }})
                .build();
    }

    @Bean
    public TeamsDataProcessor processor2() {
        return new TeamsDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Teams> writer2(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Teams>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO teams (team_id, min_year, max_year, abbreviation, nickname, year_founded, city, arena, owner, general_manager, head_coach)"
                        + " VALUES (:teamId, :minYear, :maxYear, :abbreviation, :nickname, :yearFounded, :city, :arena, :owner, :generalManager, :headCoach)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<RankingInput> reader3() {
        return new FlatFileItemReaderBuilder<RankingInput>()
                .name("rankingItemReader")
                .resource(new ClassPathResource("csv/ranking.csv"))
                .linesToSkip(1)
                .delimited()
                .names(RANKING_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(RankingInput.class);
                }})
                .build();
    }

    @Bean
    public RankingDataProcessor processor3() {
        return new RankingDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Ranking> writer3(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Ranking>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO ranking (team_id, season_id, standings_date, conference, team, g, w, l, w_pct, home_record, road_record)"
                        + " VALUES (:teamId, :seasonId, :standingsDate, :conference, :team, :g, :w, :l, :wPct, :homeRecord, :roadRecord)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<GamesDetailsInput> reader4() {
        return new FlatFileItemReaderBuilder<GamesDetailsInput>()
                .name("gamesDetailsItemReader")
                .resource(new ClassPathResource("csv/games_details_updated.csv"))
                .linesToSkip(1)
                .delimited()
                .names(GAMES_DETAILS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(GamesDetailsInput.class);
                }})
                .build();
    }

    @Bean
    public GamesDetailsDataProcessor processor4() {
        return new GamesDetailsDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<GamesDetails> writer4(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<GamesDetails>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO games_details (game_id, team_id, team_abbreviation, team_city, player_id, player_name, nickname, start_position, comment, min, fgm, fga, fg_pct, fg3m, fg3a, fg3_pct, ftm, fta, ft_pct, oreb, dreb, reb, ast, stl, blk, turnover, pf, pts, plus_minus)"
                        + " VALUES (:gameId, :teamId, :teamAbbreviation, :teamCity, :playerId, :playerName, :nickname, :startPosition, :comment, :min, :fgm, :fga, :fgPct, :fg3m, :fg3a, :fg3Pct, :ftm, :fta, :ftPct, :oreb, :dreb, :reb, :ast, :stl, :blk, :to, :pf, :pts, :plusMinus)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1, Step step2, Step step3, Step step4, Step step5) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                // TODO: run the following steps in parallel
                // also try to chunk the fifth step since it takes a minute and a half to run
//                .flow(step1)
//                .next(step2)
//                .next(step3)
//                .next(step4)
//                .next(step5)
                .flow(step5)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Players> writer) {
        return new StepBuilder("step1", jobRepository)
                .<PlayersInput, Players> chunk(10, transactionManager)
                .reader(reader1())
                .processor(processor1())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step2(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Games> writer) {
        return new StepBuilder("step2", jobRepository)
                .<GamesInput, Games> chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step3(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Teams> writer) {
        return new StepBuilder("step3", jobRepository)
                .<TeamsInput, Teams> chunk(10, transactionManager)
                .reader(reader2())
                .processor(processor2())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step4(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Ranking> writer) {
        return new StepBuilder("step4", jobRepository)
                .<RankingInput, Ranking> chunk(10, transactionManager)
                .reader(reader3())
                .processor(processor3())
                .writer(writer)
                .build();
    }

    @Bean
    public Step step5(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<GamesDetails> writer) {
        return new StepBuilder("step5", jobRepository)
                .<GamesDetailsInput, GamesDetails> chunk(10, transactionManager)
                .reader(reader4())
                .processor(processor4())
                .writer(writer)
                .build();
    }

}
