package com.taimorekhan.bookbook.models;

import java.util.UUID;
import java.util.List;

import lombok.Data;

@Data
public class Library {
    UUID id;
    String title;
    ItemType type;
    ItemStatus status;
    List<String> categories;
    String link;
    int rating;
    boolean favorite;
    String addedTimeStamp;
    String readTimeStamp;
    Author author;
}
