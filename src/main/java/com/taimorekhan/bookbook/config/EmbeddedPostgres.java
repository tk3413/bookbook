package com.taimorekhan.bookbook.config;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.shaded.com.google.common.collect.ImmutableMap;
import org.testcontainers.utility.DockerImageName;

@Component
@Profile("local")
public class EmbeddedPostgres {

    GenericContainer<?> postgreSQLContainer;

    private int mappedPort;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private Map<String, String> setupPostgresEnv() {
        Map<String, String> postgresEnv = ImmutableMap.of(
            "POSTGRES_HOST", "host",
            "POSTGRES_USER", "localUser",
            "POSTGRES_PASSWORD", "password",
            "POSTGRES_DB", "bookbook");
        return postgresEnv;
    }

    @PostConstruct
    public void init() {
        logger.info("starting postgres container");
        postgreSQLContainer = new GenericContainer<>(DockerImageName.parse("postgres:13.8"))
            .withExposedPorts(5432)
            .withEnv(setupPostgresEnv());
        postgreSQLContainer.start();
        mappedPort = postgreSQLContainer.getMappedPort(5432);
        logger.info("updated mapped port to: {}", mappedPort);
    }

    @PreDestroy
    public void teardown() {
        postgreSQLContainer.stop();
    }

    public int getMappedPort() {
        return this.mappedPort;
    }
}
