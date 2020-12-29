package com.pablan.grokking.patterns.modifiedbinary;

public class MaxInBitonicArray {

    /**
     *  Find the maximum value in a given Bitonic array. An array is considered bitonic if it is
     *  monotonically increasing and then monotonically decreasing. Monotonically increasing or
     *  decreasing means that for any index i in the array arr[i] != arr[i+1].
     *
     *  Example 1:
     *
     *  Input: [1, 3, 8, 12, 4, 2]
     *  Output: 12
     *  Explanation: The maximum number in the input bitonic array is '12'.
     *  Example 2:
     *
     *  Input: [3, 8, 3, 1]
     *  Output: 8
     *  Example 3:
     *
     *  Input: [1, 3, 8, 12]
     *  Output: 12
     *  Example 4:
     *
     *  Input: [10, 9, 8]
     *  Output: 10
     *
     */
    public int findMax(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int max = Integer.MIN_VALUE;

        while(low <= high) {
            int middle = low + ((high - low) / 2);
            max = Math.max(max, arr[middle]);

            if(arr[middle] > arr[low]) {
                // left side is ascending so peak is this one or I should search the right
                if(middle < arr.length - 1 && arr[middle + 1] < arr[middle]) {
                    // this is the peak
                    return arr[middle];
                }

                // search right
                low = middle + 1;
            } else {
               // there is a peak on the left side let's search for it
                high = middle - 1;
            }
        }

        return max;
    }
}
