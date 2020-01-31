package com.pablan.leetcode.collection.google;

import org.junit.Test;

import java.util.List;

public class WordSquaresTest {

    @Test
    public void test() {
        String[] words = new String[]{"area","lead","wall","lady","ball"};
        WordSquares wordSquares = new WordSquares();
        List<List<String>> result = wordSquares.wordSquares(words);
        System.out.println(result); // should be
        /**
         * [ "wall",
         *    "area",
         *    "lead",
         *    "lady"
         * ]
         */
    }
}
