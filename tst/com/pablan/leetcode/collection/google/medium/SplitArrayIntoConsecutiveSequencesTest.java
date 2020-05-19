package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class SplitArrayIntoConsecutiveSequencesTest {

    @Test
    public void test() {
        SplitArrayIntoConsecutiveSequences splitArrayIntoConsecutiveSequences = new SplitArrayIntoConsecutiveSequences();
        System.out.println(splitArrayIntoConsecutiveSequences.isPossible(new int[] {1,2,3,3,4,5}));
        System.out.println(splitArrayIntoConsecutiveSequences.isPossible(new int[] {1,2,3,3,4,4,5,5}));
    }
}
