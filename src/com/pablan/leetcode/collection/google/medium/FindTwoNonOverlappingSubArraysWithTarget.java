package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTwoNonOverlappingSubArraysWithTarget {

    /**
     *  Given an array of integers arr and an integer target.
     *
     * You have to find two non-overlapping sub-arrays of arr each with sum equal target.
     * There can be multiple answers so you have to find an answer where the sum of the
     * lengths of the two sub-arrays is minimum.
     *
     * Return the minimum sum of the lengths of the two required sub-arrays,
     * or return -1 if you cannot find such two sub-arrays.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [3,2,2,4,3], target = 3
     * Output: 2
     * Explanation: Only two sub-arrays have sum = 3 ([3] and [3]). The sum of their lengths is 2.
     * Example 2:
     *
     * Input: arr = [7,3,4,7], target = 7
     * Output: 2
     * Explanation: Although we have three non-overlapping sub-arrays of sum = 7 ([7], [3,4] and [7]),
     * but we will choose the first and third sub-arrays as the sum of their lengths is 2.
     * Example 3:
     *
     * Input: arr = [4,3,2,6,2,3,4], target = 6
     * Output: -1
     * Explanation: We have only one sub-array of sum = 6.
     * Example 4:
     *
     * Input: arr = [5,5,4,4,5], target = 3
     * Output: -1
     * Explanation: We cannot find a sub-array of sum = 3.
     * Example 5:
     *
     * Input: arr = [3,1,1,1,5,1,2,1], target = 3
     * Output: 3
     * Explanation: Note that sub-arrays [1,2] and [2,1] cannot be an answer because they overlap.
     *
     * Pablo's notes: https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/discuss/685463/C%2B%2B-O(N)-solution-by-prefix-sum-and-DP
     *
     * Your intuition is correct for this problem. Using sliding window you can get the minSize window that
     * adds up to target on both sides. of a number. [0, i] and [i+1, n -1]. We do that for every number and we
     * return the minimum of those operations. Now... That is a lot of work N ^ 2 because for each number
     * you are iterating left and right N times
     *
     * But here is where we get smart! We memorize the minimum size that ads up to target too the left and right
     * of each number. And then we store those, the result will be the minimum of left[i] + right[i + 1] for the entire array.
     * For example... let's look at [3,2,2,4,3], target 3
     *
     * If we go from left to right We have
     * [3] --> target, this is a possibility oof size 1
     *  move window because we are more than target
     * [2]
     * [2, 2]
     * move window because we are more than target
     * [2]
     * [2 4]
     * move window because we are more than target
     * [4]
     * move window because we are more than target
     * [3] --> target, this is a possibility of size 1
     *
     * The minimum of all those above is [1]... but now let's remember what was the minimum at each index
     * [3] --> 1
     * [3, 2] --> 1
     * 3 [2] --> 1
     * 3 [2 2] --> 1
     * ...
     * 3 2 [2 4] --> 1
     * 3 2 2 [4 3] --> 1
     * 3 2 2 4 [3] --> 1 Another possibility but same size
     *
     * Therefore left = [1, 1, 1, 1, 1, 1, 1]
     * Now same for right and it results in [1, 1, 1, 1, 1, 1]
     * At each index the result will be min (left + right + 1) == 2. Final Result is two [3] [3]
     *
     * Now do this with [4,3,2,6,2,3,4], target 6
     * left = [inf inf inf 1 1 1 1]
     * right = [ 1  1   1  1 inf inf inf]
     * result = [1  1   1  1  1   1   1]
     */
    public int minSumOfLengths(int[] arr, int target) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        int[] result = new int[arr.length];

        // calculate minSize with sliding window from left
        int windowStart = 0;
        int sum = 0;
        int minWindow = Integer.MAX_VALUE;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            sum += arr[windowEnd];
            while(sum > target) {
                sum -= arr[windowStart++];
            }

            if(sum == target) {
                // found a subarrary, let's check size
                int windowSize = windowEnd - windowStart + 1;
                minWindow = Math.min(minWindow, windowSize);
            }

            left[windowEnd] = minWindow;
        }

        // same for right side of array
        windowStart = arr.length - 1;
        sum = 0;
        minWindow = Integer.MAX_VALUE;
        for(int windowEnd = arr.length - 1; windowEnd >= 0; windowEnd--) {
            sum += arr[windowEnd];
            while(sum > target) {
                sum -= arr[windowStart--];
            }

            if(sum == target) {
                // found a subarrary, let's check size
                int windowSize = windowStart - windowEnd + 1;
                minWindow = Math.min(minWindow, windowSize);
            }

            left[windowEnd] = minWindow;
        }

        // calculate the mins and keep the minimum
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < result.length; i++) {
            int leftMin = i < 0 ? Integer.MAX_VALUE : left[i];
            int rightMin = i == result.length - 1 ? Integer.MAX_VALUE : right[i + 1];
            min = Math.min(min, leftMin + rightMin);
        }
        return min;
    }
}
