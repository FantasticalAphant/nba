package io.github.generallyspecific.nba_application.batchprocessing;

import io.github.generallyspecific.nba_application.games.GamesDataProcessor;
import io.github.generallyspecific.nba_application.games.GamesInput;
import io.github.generallyspecific.nba_application.stats.GamesDetailsDataProcessor;
import io.github.generallyspecific.nba_application.stats.GamesDetailsInput;
import io.github.generallyspecific.nba_application.players.PlayersDataProcessor;
import io.github.generallyspecific.nba_application.players.PlayersInput;
import io.github.generallyspecific.nba_application.rankings.RankingDataProcessor;
import io.github.generallyspecific.nba_application.rankings.RankingInput;
import io.github.generallyspecific.nba_application.teams.TeamsDataProcessor;
import io.github.generallyspecific.nba_application.teams.TeamsInput;
import io.github.generallyspecific.nba_application.games.Games;
import io.github.generallyspecific.nba_application.stats.GamesDetails;
import io.github.generallyspecific.nba_application.players.Players;
import io.github.generallyspecific.nba_application.rankings.Ranking;
import io.github.generallyspecific.nba_application.teams.Teams;
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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BatchConfiguration {

    // Store database field names
    private final String[] PLAYERS_FIELD_NAMES = new String[] {
            "player_name", "team_id", "player_id", "season"
    };
    private final String[] GAMES_FIELD_NAMES = new String[] {
            "game_date_est", "game_id", "game_status_text", "home_team_id", "visitor_team_id", "season", "team_id_home", "pts_home", "fg_pct_home", "ft_pct_home", "fg3_pct_home", "ast_home", "reb_home", "team_id_away", "pts_away", "fg_pct_away", "ft_pct_away", "fg3_pct_away", "ast_away", "reb_away", "home_team_wins"
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

    // Read input from the file
    @Bean
    public FlatFileItemReader<GamesInput> gamesReader() {
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

    // Process the input
    @Bean
    public GamesDataProcessor gamesProcessor() {
        return new GamesDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Games> gamesWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Games>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO games (game_date_est, game_id, game_status_text, home_team_id, visitor_team_id, season, team_id_home, pts_home, fg_pct_home, ft_pct_home, fg3_pct_home, ast_home, reb_home, team_id_away, pts_away, fg_pct_away, ft_pct_away, fg3_pct_away, ast_away, reb_away, home_team_wins)"
                        + " VALUES (:gameDateEST, :gameId, :gameStatusText, :homeTeamId, :visitorTeamId, :season, :teamIdHome, :ptsHome, :fgPctHome, :ftPctHome, :fg3PctHome, :astHome, :rebHome, :teamIdAway, :ptsAway, :fgPctAway, :ftPctAway, :fg3PctAway, :astAway, :rebAway, :homeTeamWins)")
                .dataSource(dataSource)
                .build();
    }

    // Write to the model class
    @Bean
    public FlatFileItemReader<PlayersInput> playersReader() {
        return new FlatFileItemReaderBuilder<PlayersInput>()
                .name("playersItemReader")
                .resource(new ClassPathResource("csv/players.csv"))
                .linesToSkip(1)
                .delimited()
                .names(PLAYERS_FIELD_NAMES)
                .fieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                    setTargetType(PlayersInput.class);
                }})
                .build();
    }

    @Bean
    public PlayersDataProcessor playersProcessor() {
        return new PlayersDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Players> playersWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Players>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO players (player_name, team_id, player_id, season)" +
                        " VALUES (:playerName, :teamId, :playerId, :season)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<TeamsInput> teamsReader() {
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
    public TeamsDataProcessor teamsProcessor() {
        return new TeamsDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Teams> teamsWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Teams>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO teams (team_id, min_year, max_year, abbreviation, nickname, year_founded, city, arena, owner, general_manager, head_coach)"
                        + " VALUES (:teamId, :minYear, :maxYear, :abbreviation, :nickname, :yearFounded, :city, :arena, :owner, :generalManager, :headCoach)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<RankingInput> rankingReader() {
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
    public RankingDataProcessor rankingProcessor() {
        return new RankingDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Ranking> rankingWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Ranking>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO ranking (team_id, season_id, standings_date, conference, team, g, w, l, w_pct, home_record, road_record)"
                        + " VALUES (:teamId, :seasonId, :standingsDate, :conference, :team, :g, :w, :l, :wPct, :homeRecord, :roadRecord)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public FlatFileItemReader<GamesDetailsInput> gamesDetailsReader() {
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
    public GamesDetailsDataProcessor gamesDetailsProcessor() {
        return new GamesDetailsDataProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<GamesDetails> gamesDetailsWriter(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<GamesDetails>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO games_details (game_id, team_id, team_abbreviation, team_city, player_id, player_name, nickname, start_position, comment, min, fgm, fga, fg_pct, fg3m, fg3a, fg3_pct, ftm, fta, ft_pct, oreb, dreb, reb, ast, stl, blk, turnover, pf, pts, plus_minus)"
                        + " VALUES (:gameId, :teamId, :teamAbbreviation, :teamCity, :playerId, :playerName, :nickname, :startPosition, :comment, :min, :fgm, :fga, :fgPct, :fg3m, :fg3a, :fg3Pct, :ftm, :fta, :ftPct, :oreb, :dreb, :reb, :ast, :stl, :blk, :to, :pf, :pts, :plusMinus)")
                .dataSource(dataSource)
                .build();
    }

    // run all the processors to convert data from csv to database
    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step processPlayers, Step processGames, Step processTeams, Step processRankings, Step processGamesDetails) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(processPlayers)
                .next(processGames)
                .next(processTeams)
                .next(processRankings)
                .next(processGamesDetails)
                .end()
                .build();
    }

    @Bean
    public Step processPlayers(JobRepository jobRepository,
                               PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Players> writer) {
        return new StepBuilder("processPlayers", jobRepository)
                // TODO: fine-tune chunk size for maximum speed for each step
                .<PlayersInput, Players> chunk(100, transactionManager)
                .reader(playersReader())
                .processor(playersProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step processGames(JobRepository jobRepository,
                             PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Games> writer) {
        return new StepBuilder("processGames", jobRepository)
                .<GamesInput, Games> chunk(100, transactionManager)
                .reader(gamesReader())
                .processor(gamesProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step processTeams(JobRepository jobRepository,
                             PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Teams> writer) {
        return new StepBuilder("processTeams", jobRepository)
                .<TeamsInput, Teams> chunk(100, transactionManager)
                .reader(teamsReader())
                .processor(teamsProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    public Step processRankings(JobRepository jobRepository,
                                PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Ranking> writer) {
        return new StepBuilder("processRankings", jobRepository)
                .<RankingInput, Ranking> chunk(200, transactionManager)
                .reader(rankingReader())
                .processor(rankingProcessor())
                .writer(writer)
                .build();
    }

    @Bean
    @Primary
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor("spring_batch");
    }

    @Bean
    public Step processGamesDetails(JobRepository jobRepository,
                                    PlatformTransactionManager transactionManager, JdbcBatchItemWriter<GamesDetails> writer, TaskExecutor taskExecutor) {
        return new StepBuilder("processGamesDetails", jobRepository)
                .<GamesDetailsInput, GamesDetails> chunk(200, transactionManager)
                .reader(gamesDetailsReader())
                .processor(gamesDetailsProcessor())
                .writer(writer)
                .taskExecutor(taskExecutor)
                .build();
    }

}
