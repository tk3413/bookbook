package com.taimorekhan.bookbook.ReadingList;

import java.util.UUID;
import java.util.List;
import com.taimorekhan.bookbook.Author.Author;

public class ReadingList {
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
