package com.pablan.leetcode.medium;

public class FindMinRotatedArray {
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
