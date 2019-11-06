package com.pablan.leetcode.medium;

public class ProductOfArrayExceptSelf {

    /**
     * Given an array nums of n integers where n > 1,
     * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: do this without division and in O(n) complexity
     */
    public int[] productExceptSelf(int nums[]) {
        if(nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length];
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            if(i > 0) {
                leftProduct[i] = leftProduct[i - 1] * nums[i];
            } else {
                leftProduct[i] = nums[i];
            }
        }

        for(int j = nums.length - 1; j >= 0; j--) {
            if(j < nums.length - 1) {
                rightProduct[j] = rightProduct[j + 1] * nums[j];
            } else {
                rightProduct[j] = nums[j];
            }
        }

        for(int  i = 0; i < nums.length; i++) {
            if(i == 0) {
                result[i] = rightProduct[i + 1];
            } else if(i == nums.length - 1) {
                result[i] = leftProduct[i - 1];
            } else {
                result[i] = leftProduct[i - 1] * rightProduct[i + 1];
            }
        }

        return result;
    }

}
