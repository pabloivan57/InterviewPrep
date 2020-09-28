package com.pablan.grokking.patterns.cyclicsort;

public class FindSmallestPositiveMissingNumber {

    /**
     *  Given an unsorted array containing numbers, find the smallest missing positive number in it.
     *  Example 1:
     *
     *  Input: [-3, 1, 5, 4, 2]
     *  Output: 3
     *  Explanation: The smallest missing positive number is '3'
     *  Example 2:
     *
     *  Input: [3, -2, 0, 1, 2]
     *  Output: 4
     *  Example 3:
     *
     *  Input: [3, 2, 5, 1]
     *  Output: 4
     */
    public int findNumber(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] > 0 && nums[i] <  nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            } else {
                i++;
            }
        }

        // Find very first missing non-negative
        int firstNonNegative = 0;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] < 0 || j != nums[j] - 1) {
                // this value should be first negative
                firstNonNegative = j + 1;
                break;
            }
        }

        return firstNonNegative;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
    }
}
