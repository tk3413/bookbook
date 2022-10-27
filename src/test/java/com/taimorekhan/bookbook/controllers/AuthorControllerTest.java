package com.taimorekhan.bookbook.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.taimorekhan.bookbook.models.Author;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @InjectMocks
    AuthorController authorController;

    @Test
    public void getAllAuthorsTest() {
        ResponseEntity<List<Author>> allAuthors = authorController.getAuthors();
        assertEquals(HttpStatus.OK, allAuthors.getStatusCode());
        assertEquals(1, allAuthors.getBody().size());
    }

    @Test
    public void putNewAuthorTest() {
        Author newAuthor = Author.builder().firstName("taimore").lastName("khan").build();

        assertEquals(HttpStatus.ACCEPTED, authorController.putAuthor(newAuthor).getStatusCode());
    }
}
