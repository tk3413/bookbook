package com.taimorekhan.bookbook.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AuthorController {

    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/author")
    public ResponseEntity<String> getAuthors() {
		logger.info("got a request for all authors");
		return ResponseEntity.ok("HELLO");
	}
}
