package io.github.generallyspecific.nba_application.data;

import io.github.generallyspecific.nba_application.model.Players;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

//            jdbcTemplate.query("SELECT player_name, team_id, player_id, season FROM players",
//                    (rs, row) -> new Players(
//                            rs.getString(1),
//                            Integer.parseInt(rs.getString(2)),
//                            Integer.parseInt(rs.getString(3)),
//                            Integer.parseInt(rs.getString(4)))
//            ).forEach(person -> log.info("Found <{{}}> in the database.", person));
        }
    }
}
