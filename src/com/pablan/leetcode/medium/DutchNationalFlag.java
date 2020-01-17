package com.pablan.leetcode.medium;

public class DutchNationalFlag {

    /**
     *  Given an array containing 0s, 1s and 2s, sort the array in-place.
     *  You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
     *
     * The flag of the Netherlands consists of three colors: red, white and blue;
     * and since our input array also consists of three different numbers
     * that is why it is called Dutch National Flag problem.
     *
     * Example 1:
     * Input: [1, 0, 2, 1, 0]
     * Output: [0 0 1 1 2]
     *
     * Example 2:
     * Input: [2, 2, 0, 1, 2, 0]
     * Output: [0 0 1 2 2 2 ]
     *
     * Pablo's notes: what is tricky here is that end should not move current
     */
    public void sort(int[] nums) {
        int current = 0;
        int start = 0;
        int end = nums.length - 1;

        int pivot = 1;

        while(current <= end) {
            if(nums[current] < pivot) {
                swap(nums, start, current);
                start++;
                current++;
            } else if(nums[current] > pivot) {
                swap(nums, end, current);
                end--;
            } else {
                current++;
            }
        }
    }

    private void swap(int[] nums, int idx1, int idx2) {
        int aux = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = aux;
    }
}
