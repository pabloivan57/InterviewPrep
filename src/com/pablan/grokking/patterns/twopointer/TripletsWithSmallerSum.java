package com.pablan.grokking.patterns.twopointer;

import java.util.Arrays;

public class TripletsWithSmallerSum {

    public int solve(int[] arr, int target) {
        Arrays.sort(arr);
        int tripletCount = 0;

        for(int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int targetDiff = target - arr[i] - arr[left] - arr[right];

                if (targetDiff > 0) {
                     // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                     // left and right to get a sum less than the target sum
                    tripletCount+= right - left;
                    left++;
                } else {
                    right--; // we need a pair with smaller sum
                }
            }
        }

        return tripletCount;
    }
}
