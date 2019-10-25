package com.pablan.grokking.patterns.modifiedbinary;

public class MaxInBitonicArray {

    public int findMax(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] > arr[mid + 1]) {
                high = mid;
            } else if(arr[mid] <= arr[mid + 1]) {
                low = mid + 1;
            }
        }

        // at the end of the while loop, 'low == high'
        return arr[low];
    }
}
