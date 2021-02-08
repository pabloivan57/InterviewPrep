package com.pablan.leetcode.collection.google.medium;

public class MissingNumber {

    /**
     *  Find the missing number in an array of consecutive integers.
     *
     */
    public int missingNumber(int[] array) {
        return missingNumber(array, 0, array.length - 1);
    }

    private int missingNumber(int[] nums, int start, int end) {

        while(start <= end) {
            int middle = start + ((end - start) / 2);

            int actualLeft = middle - start + 1;
            int shouldLeft = nums[middle] - nums[start];

            int actualRight = end - middle + 1;
            int shouldRight = nums[end] - nums[middle];

            if(actualLeft < shouldLeft) {
                // if next is the number that is missing return
                if(nums[middle] + 1 != nums[middle + 1]) {
                    return nums[middle] + 1;
                } else {
                    // otherwise check in the right side
                    start = middle + 1;
                }
            } else {
                // if before middle is the number that is missing
                if(nums[middle - 1] != nums[middle] - 1) {
                    return nums[middle] - 1;
                } else {
                    // check on the left
                    end = middle - 1;
                }
            }
        }

        return -1;
    }
}
