package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class ExpressiveWordsTest {

    @Test
    public void test() {
        ExpressiveWords expressiveWords = new ExpressiveWords();
        System.out.println(expressiveWords.expressiveWords("heeellooo", new String[] {"hello", "hi", "helo"})); // should be 1
        // We can extend "e" and "o" in the word "hello" to get "heeellooo".
        //We can't extend "helo" to get "heeellooo" because the group "ll" is not size 3 or more.
    }
}
