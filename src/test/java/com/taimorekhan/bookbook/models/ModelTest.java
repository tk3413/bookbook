package com.taimorekhan.bookbook.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ModelTest {
    @Test
    public void enumTest() {
        assertEquals(3, ItemStatus.values().length);
        assertEquals("COMPLETED", ItemStatus.COMPLETED.toString());
        assertEquals("NOT_STARTED", ItemStatus.NOT_STARTED.toString());
        assertEquals("STARTED", ItemStatus.STARTED.toString());

        assertEquals(4, ItemType.values().length);
        assertEquals("ARTICLE", ItemType.ARTICLE.toString());
        assertEquals("BOOK", ItemType.BOOK.toString());
        assertEquals("REFERENCE", ItemType.REFERENCE.toString());
        assertEquals("SOURCE", ItemType.SOURCE.toString());
    }
}