package com.pablan.leetcode.medium;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int[] maxSoFar = new int[nums.length];
        int[] minSoFar = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                maxSoFar[i] = nums[i];
                minSoFar[i] = nums[i];
                continue;
            }

            maxSoFar[i] = Math.max(nums[i], Math.max(maxSoFar[i - 1] * nums[i], minSoFar[i - 1] * nums[i]));
            minSoFar[i] = Math.min(nums[i], Math.min(maxSoFar[i - 1] * nums[i], minSoFar[i - 1] * nums[i]));
        }

        int maxProduct = Integer.MIN_VALUE;
        for(int i = 0; i < maxSoFar.length; i++) {
            maxProduct = Math.max(maxSoFar[i], maxProduct);
        }

        return maxProduct;
    }
}
