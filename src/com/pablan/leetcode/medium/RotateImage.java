package com.pablan.leetcode.medium;

public class RotateImage {

    /**
     * You are given an n x n 2D matrix representing an image.
     *
     * Rotate the image by 90 degrees (clockwise).
     *
     * Note:
     *
     * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
     *
     * Example 1:
     *
     * Given input matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * rotate the input matrix in-place such that it becomes:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     *
     * Pablo's notes: Remember when you have a nested loop for(int i = 0 && for(int j = 1)
     * you're starting in the diagonals and going towards the right
     *
     * https://stackoverflow.com/questions/42519/how-do-you-rotate-a-two-dimensional-array
     * This is the best explanation of this exercise
     *
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        /** transpose matrix
         *  This is magic, if you flip the values across the diagonals you will rotate 90 degrees
         *  Actually: https://medium.com/front-end-weekly/matrix-rotation-%EF%B8%8F-6550397f16ab
         *  explains it.
         */
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

        /** reverse each row
           In this block what you are doing is simply this
           imagine:
           1 7 4
           2 8 3
           3 2 1

           For each row, you take first and last elements and then flip it,
           you do it col / 2 times to not flip values twice. For example:
           -  switch 1 and 4  1 7 4 == 4 7 1
           -  now move pointers left and right, and flip 4 7 1. Switch 7 with 7 == 4 7 1
           -  now STOP! otherwise you will flip 1 and 4 again, returning to original state

            The n - 1 is because you're using matrix.length instead of matrix.length - 1
        */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
