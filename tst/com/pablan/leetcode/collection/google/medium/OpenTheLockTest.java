package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class OpenTheLockTest {

    @Test
    public void test() {
        OpenTheLock openTheLock = new OpenTheLock();
        System.out.println(openTheLock.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202")); // should be 6
        System.out.println(openTheLock.openLock(new String[] {"8888"}, "0009")); // should be 1
        System.out.println(openTheLock.openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888")); // should be -1
        System.out.println(openTheLock.openLock(new String[] {"0000"}, "0009")); // should be 1
    }
}
