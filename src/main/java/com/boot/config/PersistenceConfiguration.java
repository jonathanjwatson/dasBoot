package com.boot.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;


@Configuration
public class PersistenceConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource datasource() {
        return DataSourceBuilder.create().build();
    }

    @FlywayDataSource
    @Bean
    @ConfigurationProperties(prefix = "datasource.flyway")
    public DataSource flywayDataSource() {
        return DataSourceBuilder.create().build();
    }
}
