package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class SentenceScreenFittingTest {

    @Test
    public void test() {
        SentenceScreenFitting sentenceScreenFitting = new SentenceScreenFitting();
        System.out.println(sentenceScreenFitting.wordsTyping(new String[] {"hello", "world"}, 2, 8)); // should be 1
        System.out.println(sentenceScreenFitting.wordsTyping(new String[] {"a", "bcd", "e"}, 3, 6)); // should be 2
    }
}
