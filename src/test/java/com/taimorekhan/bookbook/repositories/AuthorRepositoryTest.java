package com.taimorekhan.bookbook.repositories;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.taimorekhan.bookbook.models.Author;

public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    public void wip() {
        Author testAuthor = Author.builder()
                .firstName("taimore")
                .lastName("khan")
                .build();
        // assert (testAuthor == authorRepository.getAuthor());
    }
}
