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

    /**
     * Thank @lycjava3 for this smart solution. To understand it easily, let me explain it with an example.
     *
     * Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
     *
     * Numbers:     2    3    4     5
     * Lefts:            2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5
     * Let’s fill the empty with 1:
     *
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
     *
     * We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n). To make it O(1), we just need to store it in a variable which is right in @lycjava3’s code.
     *
     */
    public int[] productExceptSelfSpaceOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // Calculate lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }

}
