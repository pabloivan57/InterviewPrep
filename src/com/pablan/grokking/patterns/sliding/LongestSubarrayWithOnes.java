package com.pablan.grokking.patterns.sliding;

public class LongestSubarrayWithOnes {

    /**
     * Given an array containing 0s and 1s,
     * if you are allowed to replace no more than ‘k’ 0s with 1s,
     * find the length of the longest contiguous subarray having all 1s.
     *
     * Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
     * Output: 6
     * Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
     *
     * Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
     * Output: 9
     * Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.
     *
     */
    public int findLength(int[] arr, int k) {
        int replaceCounter = k;
        int windowStart = 0;
        int maxLength = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int number = arr[windowEnd];
            if(number == 0) {
                replaceCounter--;
            }

            while(replaceCounter < 0) {
                int leavingNumber = arr[windowStart++];
                if(leavingNumber == 0) {
                    replaceCounter = replaceCounter + 1 > k ? k : replaceCounter + 1;
                }
            }

            int windowSize = windowEnd - windowStart + 1;
            maxLength = Math.max(maxLength, windowSize);
        }

        return maxLength;
    }
}
