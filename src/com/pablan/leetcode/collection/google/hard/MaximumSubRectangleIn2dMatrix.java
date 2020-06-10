package com.pablan.leetcode.collection.google.hard;

public class MaximumSubRectangleIn2dMatrix {

    /**
     *  Given a 2D matrix with integer values (and including at least 1 positive value)
     *  find the sub-rectangle with the largest sum
     *
     *  Input: [
     *    [6,  -5, -7,  4, -4],
     *    [-9,  3, -6,  5,  2],
     *    [-10, 4,  7, -6,  3],
     *    [-8,  9, -3,  3, -7]
     *  ]
     *
     *  Output: 17, comes from subrectangle
     *  [4, 7]
     *  [9, -3]
     *
     *  Pablo's notes: Watch https://www.youtube.com/watch?v=-FgseNO-6Gk, cleanest explanation
     *  But if you sort of remember, they key to this problem is to think as follows. You don't
     *  recalculate by going for i > for j, but you can just have 2 pointers at the top of each column
     *  left & right, when you expand right to the next column... then you iterate all the rows in the column
     *  and you "compress" the sums into a temporary buffer. You're effectively adding rows at this point.
     *  Later you simply want to find kadane to find out if there is a contiguous subarray that gives you the max.
     *  Since each number in the compressed temporary buffer represents a row by finding contiguous subarrays on it
     *  we are finding contiguous rectangles
     *
     *   let's say left is 0, right is 2 > from 6 to -7
     *   [[6,  -5, -7],  4, -4]  [-6]
     *   [[-9,  3, -6],  5,  2]  [-12]
     *   [[-10, 4,  7], -6,  3]  [1] -> this is max subarray, or [-10, 4, 7] is the max rectangle in left / right boundaries
     *   [[-8,  9, -3],  3, -7]  [-2]
     *
     *   Time complexity of this is O(cols * cols * rows). Why? Because you for
     *   for each left (cols), traverse to right (cols) and in between sum all rows (rows)
     */
    public int findMaxRectangleSum(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;

        int maxSum = 0;

        for(int left = 0; left < columns; left++) {

            int[] temp = new int[rows];
            for(int right = left; right < columns; right++) {

                // for each column traverse by right, sum all the values in that column
                // visualize this
                // left    right          temp
                // [1    3    4]           [8]
                // [5    6    1]           [12]
                for(int i = 0; i < rows; i++) {
                    temp[i] = temp[i] + array[i][right];
                }


                // execute kadane on temp
                int sum = kadane(temp);
                if(sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private int kadane(int[] array) {
        int[] maxBuffer = new int[array.length];
        maxBuffer[0] = array[0];
        int max = array[0];

        for(int i = 1; i < array.length; i++) {
            maxBuffer[i] = Math.max(maxBuffer[i - 1] + array[i], array[i]);
            if(maxBuffer[i] > max) {
                max = maxBuffer[i];
            }
        }

        return max;
    }
}
