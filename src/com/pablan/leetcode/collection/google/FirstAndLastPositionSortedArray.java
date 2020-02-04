package com.pablan.leetcode.collection.google;

public class FirstAndLastPositionSortedArray {

    /**
     * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * If the target is not found in the array, return [-1, -1].
     *
     * Example 1:
     *
     * Input: nums = [5,7,7,8,8,10], target = 8
     * Output: [3,4]
     * Example 2:
     *
     * Input: nums = [5,7,7,8,8,10], target = 6
     * Output: [-1,-1]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] {-1, -1};

        range[0] = findRange(0, nums.length - 1, true, nums, target);
        range[1] = findRange(0, nums.length - 1, false, nums, target);

        return range;
    }

    public int findRange(int low, int high, boolean left, int[] nums, int target) {
        while(low < high) {
            int middle = low + ((high - low) / 2);
            if(nums[middle] > target || (nums[middle] == target && left)) {
                high = middle;
            } else {
                low = middle + 1;
            }
        }

        return low;
    }
}
