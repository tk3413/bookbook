package com.taimorekhan.bookbook.interceptors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorRepositoryTest {

    @Autowired
    LogInterceptor logInterceptor;

    @Test
    public void testInterceptor() {
    }
}
