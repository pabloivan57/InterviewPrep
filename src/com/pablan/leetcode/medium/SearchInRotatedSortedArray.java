package com.pablan.leetcode.medium;

public class SearchInRotatedSortedArray {

    /**
     *
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
     *
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     *
     * You may assume no duplicate exists in the array.
     *
     * Your algorithm's runtime complexity must be in the order of O(log n).
     *
     * Example 1:
     *
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     *
     * Pablo's notes: When dealing with rotations, look for the side that is ordered and start from there
     * that makes it easy to find if the target is on the range, otherwise you attempt to search for the rotated portion
     */
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int middle = low + ((high - low) / 2);
            int midNumber = nums[middle];

            if(midNumber == target) {
                return middle;
            }

            if(midNumber >= nums[low]) {
                // left side is ordered
                if(nums[low] <= target && target < midNumber) {
                    //target is in the left side
                    high = middle - 1;
                } else {
                    // otherwise it should be on the right side (or return -1)
                    low = middle + 1;
                }
            } else {
                // right side is ordered
                if(midNumber < target && nums[high] >= target) {
                    // target is in the right side
                    low = middle + 1;
                } else {
                    // target should be on the left side (or return -1)
                    high = middle - 1;
                }
            }
        }

        return -1;
    }
}
