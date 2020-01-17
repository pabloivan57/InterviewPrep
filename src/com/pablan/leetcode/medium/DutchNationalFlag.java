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
     */
    public void sort(int[] nums) {
        // all elements < low are 0 and all elements > high are 2
        // all elements from >= low < i are 1
        int low = 0, high = nums.length - 1;
        for (int i = 0; i <= high;) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                // increment 'i' and 'low'
                i++;
                low++;
            } else if (nums[i] == 1) {
                i++;
            } else { // the case for arr[i] == 2
                swap(nums, i, high);
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
