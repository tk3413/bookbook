package com.taimorekhan.bookbook.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum ItemStatus {
    STARTED("STARTED"),
    COMPLETED("COMPLETED"),
    NOT_STARTED("NOT_STARTED");

    @Getter private String value;
}