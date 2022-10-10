package com.taimorekhan.bookbook.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ItemType {
    REFERENCE("REFERENCE"),
    BOOK("BOOK"),
    ARTICLE("ARTICLE"),
    SOURCE("SOURCE");
    
    @Getter private String value;
}