package com.taimorekhan.bookbook.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
    UUID id;
    String firstName;
    String lastName;
}
