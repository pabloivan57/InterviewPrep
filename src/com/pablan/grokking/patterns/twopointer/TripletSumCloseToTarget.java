package com.pablan.grokking.patterns.twopointer;

import java.util.Arrays;

public class TripletSumCloseToTarget {

    public int solve(int[] arr, int target) {
        Arrays.sort(arr);
        int smallestDifference = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int targetDiff = target - arr[i] - arr[left] - arr[right];
                if (targetDiff == 0) {
                    return target - targetDiff;
                }

                if (Math.abs(targetDiff) < Math.abs(smallestDifference)) {
                    smallestDifference = targetDiff;
                }

                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return target - smallestDifference;
    }
}
