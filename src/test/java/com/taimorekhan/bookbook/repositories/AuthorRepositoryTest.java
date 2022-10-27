package com.taimorekhan.bookbook.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith( SpringRunner.class )
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void testGetAllAuthors() {
        assert (1 == authorRepository.getAllAuthors().size());
    }
}
