package com.pablan.leetcode.collection.hard;

public class ProductOfArrayExceptSelf {

    /**
     * Given an array nums of n integers where n > 1,
     * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     *
     * Example:
     *
     * Input:  [1,2,3,4]
     * Output: [24,12,8,6]
     * Note: Please solve it without division and in O(n).
     *
     * Follow up:
     * Could you solve it with constant space complexity?
     * (The output array does not count as extra space for the purpose of space complexity analysis.)
     */
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length];
        int[] rightProduct = new int[nums.length];
        int[] result = new int[nums.length];

        leftProduct[0] = nums[0];
        rightProduct[nums.length - 1] = nums[nums.length - 1];

        for(int i = 1; i < nums.length; i++) {
            leftProduct[i] = nums[i] * leftProduct[i - 1];
        }

        for(int j = nums.length - 2; j >= 0; j--) {
            rightProduct[j] = nums[j] * rightProduct[j + 1];
        }

        for(int i = 0; i < nums.length; i++) {
            int left = i - 1 < 0 ? 1 : leftProduct[i - 1];
            int right = i + 1 > nums.length - 1 ? 1 : rightProduct[i + 1];
            result[i] = left * right;
        }

        return result;
    }
}
