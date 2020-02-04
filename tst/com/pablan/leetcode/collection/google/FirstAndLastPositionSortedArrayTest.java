package com.pablan.leetcode.collection.google;

import org.junit.Test;

public class FirstAndLastPositionSortedArrayTest {

    @Test
    public void test() {
        FirstAndLastPositionSortedArray firstAndLastPositionSortedArray = new FirstAndLastPositionSortedArray();
        System.out.println(firstAndLastPositionSortedArray.searchRange(new int[] {5,7,7,8,8,10}, 8)); // Should be [3, 4]
    }
}
