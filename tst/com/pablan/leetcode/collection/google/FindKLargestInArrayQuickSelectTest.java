package com.pablan.leetcode.collection.google;

import org.junit.Test;

public class FindKLargestInArrayQuickSelectTest {

    @Test
    public void test() {
        FindKLargestInArrayQuickSelect findKLargestInArrayQuickSelect = new FindKLargestInArrayQuickSelect();
        System.out.println(findKLargestInArrayQuickSelect.findKthLargest(new int[] {3,2,1,5,6,4}, 2)); // should be 5
        System.out.println(findKLargestInArrayQuickSelect.findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4)); // should be 4
    }
}
