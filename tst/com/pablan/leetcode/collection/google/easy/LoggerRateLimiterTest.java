package com.pablan.leetcode.collection.google.easy;

import org.junit.Test;

public class LoggerRateLimiterTest {

    @Test
    public void test() {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        System.out.println(logger.shouldPrintMessage(1, "foo")); // should be true
        System.out.println(logger.shouldPrintMessage(2,"bar")); // should be true
        System.out.println(logger.shouldPrintMessage(3,"foo")); // should be false
        System.out.println(logger.shouldPrintMessage(8,"bar")); // should be false
        System.out.println(logger.shouldPrintMessage(10,"foo")); // should be false
        System.out.println(logger.shouldPrintMessage(11,"foo")); // should be true
    }
}
