package com.taimorekhan.bookbook.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Postgres {

    @Value("${spring.datasource.username}")
    String userName;

    @Value("${spring.datasource.password}")
    String password;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.port:5432}")
    String port;

    String DATABASE_NAME = "bookbook";

    @Autowired(required=false)
    EmbeddedPostgres embeddedPostgres;

    @Bean
    public DataSource postgresDatasource() {
        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.postgresql.Driver");
        dataSourceBuilder.url(createUri());
        dataSourceBuilder.username(userName);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

    private String createUri() {
        if (embeddedPostgres != null) {
            port = String.valueOf(embeddedPostgres.getMappedPort());
        }
        return url + ":" + port + "/" + DATABASE_NAME;
    }

}
