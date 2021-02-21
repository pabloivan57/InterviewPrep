package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class AlphabetBoardTest {

    @Test
    public void test() {
        AlphabetBoard alphabetBoard = new AlphabetBoard();
        System.out.println(alphabetBoard.alphabetBoardPath("leet")); // should be DDR!UURRR!!DDD!
    }
}
