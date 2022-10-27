package com.taimorekhan.bookbook.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info("recieved [" + request.getMethod() + "] on [" + request.getRequestURL() + "]");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        // do nothing!
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable Exception ex) throws Exception {
        if (ex != null) {
            logger.error("failed to complete [" + request.getMethod() + "] on [" + request.getRequestURL() + "] due to: [" + ex.getMessage() + "]");
        }
        logger.info("completed [" + request.getMethod() + "] on [" + request.getRequestURL() + "]");
    }
}
