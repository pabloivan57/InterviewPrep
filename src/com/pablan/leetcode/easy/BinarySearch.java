package com.pablan.leetcode.easy;

public class BinarySearch {

    public int find(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while(low <= high) {
            int middle = low + ((high - low) / 2);

            if(array[middle] == target) {
                return middle;
            } else if(array[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }
}
