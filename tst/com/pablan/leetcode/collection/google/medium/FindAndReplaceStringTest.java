package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class FindAndReplaceStringTest {

    @Test
    public void test() {
        FindAndReplaceString findAndReplaceString = new FindAndReplaceString();
        System.out.println(findAndReplaceString.findReplaceString("abcd",
                new int[] {0, 2},
                new String[] {"a", "cd"},
                new String[] {"eee", "fff"})); // Should be eeebffff
    }
}
