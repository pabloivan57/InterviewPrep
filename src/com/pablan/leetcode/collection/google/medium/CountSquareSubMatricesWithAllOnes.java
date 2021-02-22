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
     *
     *
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
     *  Pablo's DP explanation:
     *  The best explanation for DP is https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
     *
     *  Basically, imagine you can make "combos" only if the 3 surrounding values around a cell are "1"
     *
     *  1 ==> 1 square
     *
     *  1 1
     *  1 (1)     ==> Here we have a combo because all sorrounding of 1,1 are 1.. therefore we actually have 2 squares here
     *    |
     *    v
     *   transforms to
     *
     *  1  1
     *  1  2
     *
     *  The result then is just the sum of all values computed. In other words 5
     *
     *  Now look at a better example:
     *
     *  ______
     *| 1 0   1
     *| 1 (1) 0    We don't even bother with edges because we know they cannot start a combo. So we start at pos 1,1
     *| 1 1   0
     *   |
     *   v
     *  here we cannot make a combo. So turns out the cell itself is as many squares as I can make
     *
     *  1 0  1
     *  1 1  0    ... we keep moving, the next valid one is 2,1
     *  1 1  0
     *
     *   |
     *   V
     *
     *  1 0   1
     *  1 1   0  .. here we can make a combo. Turns out 2,1 equals 2 squares
     *  1 (1) 0
     *
     *   |
     *   v
     *
     *  1 0 1
     *  1 1 0   .. Total squares equals sum of all values = 7
     *  1 2 0
     */

    public int countSquares(int[][] matrix) {
        int result = 0;

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == 1) {
                    if(row > 0 && col > 0) {
                        // this could make a combo
                        matrix[row][col] = Math.min(matrix[row - 1][col - 1], Math.min(matrix[row - 1][col], matrix[row][col - 1])) + 1;
                    }
                    result += matrix[row][col];
                }
            }
        }

        return result;
    }

    public int countSquaresLame(int[][] matrix) {
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
