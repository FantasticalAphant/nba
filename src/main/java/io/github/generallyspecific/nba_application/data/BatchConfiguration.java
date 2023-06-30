package io.github.generallyspecific.nba_application.data;

import io.github.generallyspecific.nba_application.model.Games;
import io.github.generallyspecific.nba_application.model.Players;
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

// update this file so that it takes in another CSV file and writes to a different table

@Configuration
public class BatchConfiguration {

    private final String[] PLAYERS_FIELD_NAMES = new String[] {
            "player_name", "team_id", "player_id", "season"
    };

    private final String[] GAMES_FIELD_NAMES = new String[] {
            "game_date_est","game_id","game_status_text","home_team_id","visitor_team_id","season","team_id_home","pts_home","fg_pct_home","ft_pct_home","fg3_pct_home","ast_home","reb_home","team_id_away","pts_away","fg_pct_away","ft_pct_away","fg3_pct_away","ast_away","reb_away","home_team_wins"
    };

    @Bean
    public FlatFileItemReader<GamesInput> reader() {
        return new FlatFileItemReaderBuilder<GamesInput>()
                .name("gamesItemReader")
                .resource(new ClassPathResource("games.csv"))
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
                .resource(new ClassPathResource("players.csv"))
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
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1, Step step2) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1)
                .next(step2)
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

}
