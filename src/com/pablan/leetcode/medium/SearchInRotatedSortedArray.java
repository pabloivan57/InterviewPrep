package com.pablan.leetcode.medium;

public class SearchInRotatedSortedArray {

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
