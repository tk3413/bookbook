package com.taimorekhan.bookbook.models;

import java.util.UUID;
import java.util.List;
import com.taimorekhan.bookbook.models.Author;
import lombok.Data;

@Data
public class Library {
    UUID id;
    String title;
    Author author;
    String type;
    String status;
    List<String> categories;
    String link;
    int rating;
    boolean favorite;
    String addedTimeStamp;
    String readTimeStamp;
}
