package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class FindTwoNonOverlappingSubArraysWithTargetTest {

    @Test
    public void test() {
        FindTwoNonOverlappingSubArraysWithTarget findTwoNonOverlappingSubArraysWithTarget = new FindTwoNonOverlappingSubArraysWithTarget();
        System.out.println(findTwoNonOverlappingSubArraysWithTarget.minSumOfLengths(new int[] {3,2,2,4,3}, 3)); // Should be 2
        System.out.println(findTwoNonOverlappingSubArraysWithTarget.minSumOfLengths(new int[] {7,3,4,7}, 7)); // Should be 2

    }
}
