package com.pablan.grokking.patterns.modifiedbinary;

public class SearchBitonicArray {

    /**
     *  Given a Bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic if it
     *  is monotonically increasing and then monotonically decreasing. Monotonically increasing or decreasing
     *  means that for any index i in the array arr[i] != arr[i+1].
     *
     *  Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
     *
     *  Example 1:
     *
     *  Input: [1, 3, 8, 4, 3], key=4
     *  Output: 3
     *  Example 2:
     *
     *  Input: [3, 8, 3, 1], key=8
     *  Output: 1
     *  Example 3:
     *
     *  Input: [1, 3, 8, 12], key=12
     *  Output: 3
     *  Example 4:
     *
     *  Input: [10, 9, 8], key=10
     *  Output: 0
     */
    public int search(int arr[], int key) {
        int maxIndex = findMax(arr);
        int left = binarySearch(0, maxIndex, arr, key);
        int right = binarySearch(maxIndex, arr.length - 1, arr, key);

        return left == -1 ? right : left;
    }

    private int binarySearch(int start, int end, int[] arr, int key) {
        int low = start;
        int high = end;
        while(low <= high) {
            int middle = low + ((high - low) / 2);

            if(arr[middle] == key) {
                return middle;
            }

            if(key < arr[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    private int findMax(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int middle = low + ((high - low) / 2);

            if (arr[low] < arr[middle]) {
                // either this is the peak or I have to find the peak on the right side
                if (middle < arr.length - 1 && arr[middle + 1] < arr[middle]) {
                    return middle;
                }

                low = middle + 1;
            }  else {
                // peaks is in the left side
                high = middle - 1;
            }
        }

        // it's sorted array otherwise
        return arr.length - 1;
    }
}
