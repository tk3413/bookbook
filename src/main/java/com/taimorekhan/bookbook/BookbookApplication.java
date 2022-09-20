package com.taimorekhan.bookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookbookApplication {

    @RequestMapping("/")
    public String home() {
	return "Hello Home";
    }

	public static void main(String[] args) {
		SpringApplication.run(BookbookApplication.class, args);
	}

}
