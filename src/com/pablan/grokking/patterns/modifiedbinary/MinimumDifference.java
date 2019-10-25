package com.pablan.grokking.patterns.modifiedbinary;

public class MinimumDifference {

    // For this problem think in terms
    // "The minimum difference will be the difference between key and the max index less than key"
    public int searchMinDiffElement(int[] arr, int key) {
        if(key < arr[0]) {
            return arr[0];
        }
        // This is important since array is sorted the minimum diff will be key - max element
        if(key > arr[arr.length - 1]) {
            return arr[arr.length - 1];
        }

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            } else {
                return arr[mid];
            }
        }

        // at the end of the while loop, 'start == end+1'
        // we are not able to find the element in the given array
        // return the element which is closest to the 'key'
        if ((arr[low] - key) < (key - arr[high]))
            return arr[low];

        return arr[high];
    }
}
