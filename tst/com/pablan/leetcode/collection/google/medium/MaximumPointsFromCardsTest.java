package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class MaximumPointsFromCardsTest {

    @Test
    public void test() {
        MaximumPointsFromCards maximumPointsFromCards = new MaximumPointsFromCards();
        System.out.println(maximumPointsFromCards.maxScore(new int[]{1,2,3,4,5,6,1}, 3)); // should be 12
        System.out.println(maximumPointsFromCards.maxScore(new int[]{2,2,2}, 2)); // should be 4
        System.out.println(maximumPointsFromCards.maxScore(new int[]{9,7,7,9,7,7,9}, 7)); // should be 55
        System.out.println(maximumPointsFromCards.maxScore(new int[]{1,1000,1}, 1)); // should be 1
        System.out.println(maximumPointsFromCards.maxScore(new int[]{1,79,80,1,1,1,200,1}, 3)); // should be 202

        // worthy examples
        System.out.println(maximumPointsFromCards.maxScore(new int[]{100,40,17,9,73,75}, 3)); // should be 248
    }
}
