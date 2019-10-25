package com.pablan.leetcode.medium;

import com.pablan.leetcode.easy.MaximumSubarray;
import org.junit.Test;

public class MaximumSubarrayTest {

    @Test
    public void test() {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
