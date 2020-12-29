package com.pablan.grokking.patterns.modifiedbinary;

public class SearchRotatedArray {

    /**
     *  Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number,
     *  find if a given ‘key’ is present in it.
     *
     *  Write a function to return the index of the ‘key’ in the rotated array. If the ‘key’ is not present,
     *  return -1. You can assume that the given array does not have any duplicates.
     *
     *  Example 1:
     *
     *  Input: [10, 15, 1, 3, 8], key = 15
     *  Output: 1
     *  Explanation: '15' is present in the array at index '1'.
     *
     *  Example 2:
     *
     *  Input: [4, 5, 7, 9, 10, -1, 2], key = 10
     *  Output: 4
     *  Explanation: '10' is present in the array at index '4'.
     */
    public int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int middle = low + ((high - low) / 2);

            // If found, return element
            if(key == arr[middle]) {
                return middle;
            }

            // if left side is sorted
            if(arr[low] < arr[middle]) {
                // if value is on the left
                if(arr[low] <= key && key < arr[middle]) {
                    high = middle - 1;
                } else {
                    low = middle + 1;
                }
            // if right side is sorted
            } else if(arr[middle] < arr[high]){
                // if value is on the right
                if(key > arr[middle] && key <= arr[high]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }

        return -1;
    }
}
