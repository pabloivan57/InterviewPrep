package com.pablan.leetcode.medium;

public class FindMinRotatedArray {

    /**
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
     *
     * Find the minimum element.
     *
     * You may assume no duplicate exists in the array.
     *
     * Example 1:
     *
     * Input: [3,4,5,1,2]
     * Output: 1
     *
     */
    public int findMin(int[] nums) {
       if(nums.length == 1) {
           return nums[0];
       }

       int low =  0;
       int high = nums.length - 1;

       if(nums[high] > nums[low]) {
           // array is sorted
           return nums[low];
       }

       while(low <= high) {
           int middle = low + ((high - low) / 2);

           if(nums[middle] > nums[middle + 1]) {
               return nums[middle + 1];
           }

           if(nums[middle - 1] > nums[middle]) {
               return nums[middle];
           }

           if(nums[low] > nums[middle]) {
               // need to find the rotation in the left side
               high = middle - 1;
           } else {
               low = middle + 1;
           }
       }

       return  -1;
    }
}
