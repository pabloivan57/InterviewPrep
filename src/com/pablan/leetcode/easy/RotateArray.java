package com.pablan.leetcode.easy;

public class RotateArray {

    /**
     * Given an array, rotate the array to the right by k steps, where k is non-negative.
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5,6,7] and k = 3
     * Output: [5,6,7,1,2,3,4]
     * Explanation:
     * rotate 1 steps to the right: [7,1,2,3,4,5,6]
     * rotate 2 steps to the right: [6,7,1,2,3,4,5]
     * rotate 3 steps to the right: [5,6,7,1,2,3,4]
     * Example 2:
     *
     * Input: [-1,-100,3,99] and k = 2
     * Output: [3,99,-1,-100]
     * Explanation:
     * rotate 1 steps to the right: [99,-1,-100,3]
     * rotate 2 steps to the right: [3,99,-1,-100]
     * Note:
     *
     */
    public int[] rotate(int[] nums, int k) {
        rotate2(nums, k);
        return nums;
    }

    // On this approach we reverse the list, it is more straight forward than cyclic sort but more repetitive
    private void rotate1(int[] nums, int k) {
        // step 1 rotate the whole list
        reverse(nums, 0, nums.length - 1);

        // step 2 rotate the first k elements
        reverse(nums, 0, k - 1);

        // step 3 rotate the last n - k elements
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        int aux = 0;
        while(start < end) {
            aux = nums[start];
            nums[start] = nums[end];
            nums[end] = aux;
            start++;
            end--;
        }
    }

    // On this approach we replace numbers in a cyclical manner
    private void rotate2(int[] nums, int k) {
        // Check for overflow possibilities
        k = k % nums.length;

        int count = 0;
        for(int startIdx = 0; count < nums.length; startIdx++) {
            int prevNum = nums[startIdx];
            int nextIdx = startIdx + k;
            while(nextIdx != startIdx) {
                int aux = nums[nextIdx];
                nums[nextIdx] = prevNum;
                count++;
                prevNum = aux;
                nextIdx = (nextIdx + k) % nums.length;
            }

            nums[nextIdx] = prevNum;
            count++;
        }
    }
}
