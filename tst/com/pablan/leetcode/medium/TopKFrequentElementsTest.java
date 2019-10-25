package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class TopKFrequentElementsTest {

    /*
        Given a non-empty array of integers, return the k most frequent elements.

        Example 1:

        Input: nums = [1,1,1,2,2,3], k = 2
        Output: [1,2]
     */
    @Test
    public void test() {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(topKFrequentElements.topKFrequent(new int[] {1,1,1,2,2,3}, 2));
    }
}
