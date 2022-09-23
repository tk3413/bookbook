package com.taimorekhan.bookbook.config;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.utility.DockerImageName;

@Component
@Profile("local")
public class EmbeddedPostgres {

    GenericContainer<?> postgreSQLContainer;

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @PostConstruct
    public void init() {
	logger.info("starting postgres container");
	postgreSQLContainer = new GenericContainer(DockerImageName.parse("postgres:13.8"));
	postgreSQLContainer.start();
    }

    @PreDestroy
    public void teardown() {
	postgreSQLContainer.stop();
    }
}
