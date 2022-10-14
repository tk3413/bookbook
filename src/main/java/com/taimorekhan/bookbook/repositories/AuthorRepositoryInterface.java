package com.taimorekhan.bookbook.repositories;

import java.util.List;

import com.taimorekhan.bookbook.models.Author;

public interface AuthorRepositoryInterface {
    Author getAuthor();
    List<Author> getAllAuthors();
}
