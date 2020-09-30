package com.pablan.leetcode.collection.google.hard;

public class FindMissingPositive {

    /**
     * Given an unsorted integer array, find the smallest missing positive integer.
     *
     * Example 1:
     *
     * Input: [1,2,0]
     * Output: 3
     * Example 2:
     *
     * Input: [3,4,-1,1]
     * Output: 2
     * Example 3:
     *
     * Input: [7,8,9,11,12]
     * Output: 10
     * Follow up:
     *
     * Your algorithm should run in O(n) time and uses constant extra space.
     *
     * Pablo's notes: This is a varation on cyclic sort pattern, if you don't remember
     * check grokkings cyclic sort chapter. Regardless, what is different here is that
     * you want to place numbers in their respective position within the array skipping
     * negatives and 0... at the end of the day we want non-negative integer
     */
    public int firstMissingPositive(int[] nums) {
        int i = 0;

        if(nums == null || nums.length == 0) {
            return 1;
        }

        while(i < nums.length) {
            int j = nums[i] - 1; // This number represents the position the number tells me it belongs to
                                 //  4, 2, 3, 1 --> in this case number in position 0 is telling me it
                                 // should go in position 4 - 1, that's what j represents

            if(nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[j]) {
                swap(i, j, nums);
            } else {
                i++;
            }
        }

        // When I have all numbers in it's correct position then
        for(int cur = 0; cur < nums.length; cur++) {
            // If the number in this position isn't supposed to go here...
            if(cur != nums[cur] - 1) {
                return cur + 1;
            }
        }

        return nums[nums.length - 1] + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
