package com.pablan.leetcode.medium;

public class ProductOfArrayExceptSelf {

    //Given an array nums of n integers where n > 1,
    //return an array output such that output[i] is equal to the product of all the elements of nums except nums[i]

    // Note: do this without division and in O(n) complexity
    public int[] productExceptSelf(int nums[]) {
        int[] result = new int[nums.length];
        int[] leftProducts = new int[nums.length];
        int[] rightProducts = new int[nums.length];

        leftProducts[0] = 1; // since left products contains all elements to the left then there wouldn't be any before 0
        for(int i = 1; i < nums.length; i++) {
            leftProducts[i] = leftProducts[i - 1] * nums[i - 1];
        }

        rightProducts[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
                rightProducts[i] = rightProducts[i + 1] * nums[i + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            result[i] = leftProducts[i] * rightProducts[i];
        }

        return result;
    }

}
