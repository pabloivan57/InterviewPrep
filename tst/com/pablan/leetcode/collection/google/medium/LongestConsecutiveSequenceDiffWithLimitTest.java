package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class LongestConsecutiveSequenceDiffWithLimitTest {

    @Test
    public void test() {
        LongestConsecutiveSequenceDiffWithLimit limit = new LongestConsecutiveSequenceDiffWithLimit();
        System.out.println(limit.longestSubarray(new int[] {8,2,4,7}, 4)); // should be 2
        System.out.println(limit.longestSubarrayDeque(new int[] {10,1,2,4,7,2}, 5)); // should be 4
        System.out.println(limit.longestSubarray(new int[] {4,2,2,2,4,4,2,2}, 0)); // should be 3
    }
}
