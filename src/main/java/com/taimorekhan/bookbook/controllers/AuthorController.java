package com.taimorekhan.bookbook.controllers;

import java.util.ArrayList;
import java.util.List;

import com.taimorekhan.bookbook.models.Author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class AuthorController {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAuthors() {
		Author testAuthor = Author.builder().build();
		List<Author> authorList = new ArrayList<Author>();
		authorList.add(testAuthor);
		logger.info("got a request for all authors");
		return ResponseEntity.ok(authorList);
	}

	@PutMapping("/author")
	public ResponseEntity<String> putAuthor(Author newAuthor) {
		logger.info("got a request to insert new author");
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
