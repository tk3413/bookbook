package com.taimorekhan.bookbook.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class AuthorControllerTest {

    @InjectMocks
    AuthorController authorController;


    @Test
    public void getAllAuthorsTest() {
	assertEquals(HttpStatus.OK, authorController.getAuthors().getStatusCode());
    }
}
