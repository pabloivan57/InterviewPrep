package com.pablan.leetcode.collection.google.hard;

import java.util.TreeSet;

public class MaxSumOfRectangleNoLargerThanK {

    /**
     * Given a non-empty 2D matrix  and an integer k,
     * find the max sum of a rectangle in the matrix such that its sum is no larger than k.
     *
     * Input: matrix = [[1,0,1],[0,-2,3]], k = 2
     * Output: 2
     * Explanation: Because the sum of rectangle [[0, 1], [-2, 3]] is 2,
     *              and 2 is the max number no larger than k (k = 2).
     *
     * Pablo's notes: This is a 2 step problem
     *
     * 1.- Learn how to find the max subrectangle. Look at the problem MaximumSubRectangleIn2dMatrix
     * 2.- Learn how to find the max subarray less than K.
     * https://www.quora.com/Given-an-array-of-integers-A-and-an-integer-k-find-a-subarray-that-contains-the-largest-sum-subject-to-a-constraint-that-the-sum-is-less-than-k
     *
     * Here is the explanation of 2.
     * a) Provided a subarray is an adjacent array
     * b) You want to find a range [i, j] <= k or, cum[j] - cum[i] <= k !!This is only because they are adjacent, otherwise this becomes SubsetSum
     * c) Since we can calculate cum[i] in one pass
     *   cum[j] - cum[i] <= k --> cum[j] - cum[i] - k <= k - k --> cum[j] - cum[i] - k <= 0 -->
     *   cum[j] - cum[i] - k + cum[i] <= cum[i] --> cum[j] - k <= cum[i]
     *
     * d) cum[i] is the value we are looking for since we 1) compressed sums into a column 2) found the max sum of a subarray less than k
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int maxSum = 0;
        for(int p0 = 0; p0 < columns; p0++) {

            int[] sums = new int[rows];
            for(int p1 = p0; p1 < columns; p1++) {
                //create sums
                for(int row = 0; row< row; row++) {
                    sums[row] = sums[row] + matrix[p1][row];
                }

                // Create cum[i]
                TreeSet<Integer> cumulative = new TreeSet<>();
                int acc = 0; // accumulator
                for(int i = 0; i < sums.length; i++) {
                    acc += sums[i];
                    cumulative.add(acc);
                }

                // Process cum[j]
                acc = 0;
                for(int i = 0; i < sums.length; i++) {
                    acc += sums[i];
                    Integer result = cumulative.ceiling(acc - k); // this is the same as finding cum[i] >= cum[j] - k
                    if(result != null) {
                        maxSum = Math.max(maxSum, result);
                    }
                }
            }
        }

        return maxSum;
    }
}
