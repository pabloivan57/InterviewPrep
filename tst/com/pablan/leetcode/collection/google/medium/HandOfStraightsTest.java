package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class HandOfStraightsTest {

    @Test
    public void test() {
        HandOfStraights handOfStraights = new HandOfStraights();
        System.out.println(handOfStraights.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3)); // should be true
        System.out.println(handOfStraights.isNStraightHand(new int[] {1,2,3,4,5}, 4)); // should be false
    }
}
