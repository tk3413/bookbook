package com.taimorekhan.bookbook.models;

import java.util.UUID;
import lombok.Data;

@Data
public class Author {
    UUID id;
    String firstName;
    String lastName;
}
