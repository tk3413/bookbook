package com.taimorekhan.bookbook.config;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import org.testcontainers.utility.DockerImageName;

@Component
@Profile("local")
public class EmbeddedPostgres {

    GenericContainer<?> postgreSQLContainer;

    DockerImageName imageName = DockerImageName.parse("postgres:13.8");

    private int mappedPort;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    Connection conn;

    private Connection getConnection(String url) {
        try {
            return DataSourceBuilder.create()
                    .driverClassName("org.postgresql.Driver")
                    .url(url)
                    .username("localUser")
                    .password("password")
                    .build()
                    .getConnection();
        } catch (SQLException e) {
            logger.error("Unable to establish connection to embedded database");
            e.printStackTrace();
        }
        return null;
    }

    private Map<String, String> setupPostgresEnv() {
        Map<String, String> postgresEnv = ImmutableMap.of(
                "POSTGRES_USER", "localUser",
                "POSTGRES_PASSWORD", "password",
                "POSTGRES_DB", "bookbook");
        return postgresEnv;
    }

    @PostConstruct
    public void init() {
        logger.info("starting postgres container");
        postgreSQLContainer = new GenericContainer<>(imageName)
                .withExposedPorts(5432)
                .withEnv(setupPostgresEnv());
        postgreSQLContainer.start();
        mappedPort = postgreSQLContainer.getMappedPort(5432);
        logger.info("updated mapped port to: {}", mappedPort);
        setupTable();
        seedData();
    }

    @PreDestroy
    public void teardown() {
        postgreSQLContainer.stop();
    }

    public int getMappedPort() {
        return this.mappedPort;
    }

    private void setupTable() {
        String url = "jdbc:postgresql://localhost:" + this.mappedPort + "/bookbook";
        try {
            conn = getConnection(url);
            conn.prepareStatement("create table if not exists authors" +
                    "(id int PRIMARY KEY, firstName varchar(500), lastName varchar(500))")
                    .executeQuery()
                    .close();
        } catch (SQLException e) {
            logger.error("error initializing tables for embedded db");
            e.printStackTrace();
        }
    }

    private void seedData() {
        String url = "jdbc:postgresql://localhost:" + this.mappedPort + "/bookbook";
        try {
            conn = getConnection(url);
            conn.prepareStatement("insert into authors" +
                    "(id, firstName, lastName) values (1, 'taimore', 'khan')")
                    .executeQuery()
                    .close();
        } catch (SQLException e) {
            logger.error("error initializing tables for embedded db");
            e.printStackTrace();
        }
    }
}
