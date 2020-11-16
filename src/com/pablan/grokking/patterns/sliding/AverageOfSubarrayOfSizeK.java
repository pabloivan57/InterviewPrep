package com.pablan.grokking.patterns.sliding;

public class AverageOfSubarrayOfSizeK {

    /**
     *  Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
     *
     *  Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array.
     *
     *  1+3+2+6−1 / 5 => 2.2
     *  3+2+6−1+4 / 5 => 2.8
     *  ...
     *
     *  Output: [2.2, 2.8, 2.4, 3.6, 2.8]
     */
    public double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1]; // that extra -1 is the contraction of the first 5 numbers.
                                                          // If you do total - length you get the numbers between 5 and 9
                                                         // therefore you substract only 4 to represent an additional number

        int sum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if(windowEnd < K - 1) {
                sum += arr[windowEnd];
            } else {
                sum += arr[windowEnd];
                result[windowEnd - (K - 1)] = (double)sum / K;
                sum -= arr[windowStart++];
            }
        }

        return result;
    }
}
