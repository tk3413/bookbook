package com.taimorekhan.bookbook.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.taimorekhan.bookbook.models.Author;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @InjectMocks
    AuthorController authorController;

    @Test
    public void getAllAuthorsTest() {
        assertEquals(HttpStatus.OK, authorController.getAuthors().getStatusCode());
    }

    @Test
    public void putNewAuthorTest() {
        Author newAuthor = Author.builder().firstName("taimore").lastName("khan").build();

        assertEquals(HttpStatus.ACCEPTED, authorController.putAuthor(newAuthor).getStatusCode());
    }
}
