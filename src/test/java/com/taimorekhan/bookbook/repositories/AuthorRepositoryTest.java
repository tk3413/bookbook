package com.taimorekhan.bookbook.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taimorekhan.bookbook.models.Author;

@RunWith( SpringRunner.class )
@SpringBootTest
public class AuthorRepositoryTest {

    @Autowired
    AuthorRepository authorRepository;

    @Test
    public void testGetAuthor() {
        Author testAuthor = Author.builder()
                .firstName("taimore")
                .lastName("khan")
                .build();
        assert (null == authorRepository.getAuthor());
    }
}
