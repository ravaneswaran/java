package rave.code.nse.web.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

@Configuration
public class DataSourceConfig {

    private static final Logger LOGGER = Logger.getLogger(DataSourceConfig.class.getName());

    @Bean
    public DataSource dataSource() {
        LOGGER.log(Level.INFO, "[[[ *************** Configuring Hikari DataSource *************** ]]]");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/stock_market_dev");
        config.setUsername("admin");
        config.setPassword("admin");
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5);
        config.setIdleTimeout(300000);
        config.setMaxLifetime(1800000);

        return new HikariDataSource(config);
    }
}
