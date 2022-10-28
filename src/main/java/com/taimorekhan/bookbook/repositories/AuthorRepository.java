package com.taimorekhan.bookbook.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.taimorekhan.bookbook.config.Postgres;
import com.taimorekhan.bookbook.models.Author;

@Repository
public class AuthorRepository implements AuthorRepositoryInterface {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    Postgres postgresConfig;

    @Override
    public List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<Author>();
        try {
            ResultSet resultset = postgresConfig.postgresDatasource().getConnection().createStatement()
                    .executeQuery("SELECT * FROM authors");
            while (resultset.next()) {
                authors.add(Author.builder()
                        .firstName(resultset.getString("firstName"))
                        .lastName(resultset.getString("lastName")).build());
            }
        } catch (SQLException e) {
            logger.error("failed to retrieve author list from database due to {}");
        }
        return authors;
    }

    @Override
    public Author getAuthor() {
        // TODO Auto-generated method stub
        return null;
    }
}
