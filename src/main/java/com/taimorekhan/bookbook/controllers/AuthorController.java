package com.taimorekhan.bookbook.controllers;

import java.util.List;

import com.taimorekhan.bookbook.models.Author;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@GetMapping("/author")
	public ResponseEntity<List<Author>> getAuthors() {
		logger.info("got a request for all authors");
		return new ResponseEntity<List<Author>>(HttpStatus.OK);
	}
}
