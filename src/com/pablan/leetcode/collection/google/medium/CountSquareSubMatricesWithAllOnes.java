package com.pablan.leetcode.collection.google.medium;

public class CountSquareSubMatricesWithAllOnes {

    /**
     *  Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
     *
     *  Example 1:
     *
     * Input: matrix =
     * [
     *   [0,1,1,1],
     *   [1,1,1,1],
     *   [0,1,1,1]
     * ]
     * Output: 15
     * Explanation:
     * There are 10 squares of side 1.
     * There are 4 squares of side 2.
     * There is  1 square of side 3.
     * Total number of squares = 10 + 4 + 1 = 15.
     *
     * Input: matrix =
     * [
     *   [1,0,1],
     *   [1,1,0],
     *   [1,1,0]
     * ]
     * Output: 7
     * Explanation:
     * There are 6 squares of side 1.
     * There is 1 square of side 2.
     * Total number of squares = 6 + 1 = 7.
     *
     */
    public int countSquares(int[][] matrix) {
        int totalSquares = 0;

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 1) {
                    totalSquares = totalSquares + expand(row, col, row, col, matrix);
                }
            }
        }

        return totalSquares;
    }

    public int expand(int row, int col, int rootRow, int rootCol, int[][] matrix) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] == 0) {
            return 0;
        }

        // check col vertically
        int currentRow = row;
        while(currentRow >= rootRow) {
            if(matrix[currentRow][col] == 0) {
                return 0;
            }
            currentRow--;
        }

        // check row horizontally
        int currentCol = col;
        while(currentCol >= rootCol) {
            if(matrix[row][currentCol] == 0) {
                return 0;
            }
            currentCol--;
        }

        int expandResult = expand(row + 1, col + 1, rootRow, rootCol, matrix);

        return 1 + expandResult;
    }

}
