package com.pablan.leetcode.collection.hard;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    /**
     * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     *
     * Example 1:
     *
     * Input:
     * [
     *  [ 1, 2, 3 ],
     *  [ 4, 5, 6 ],
     *  [ 7, 8, 9 ]
     * ]
     * Output: [1,2,3,6,9,8,7,4,5]
     * Example 2:
     *
     * Input:
     * [
     *   [1, 2, 3, 4],
     *   [5, 6, 7, 8],
     *   [9,10,11,12]
     * ]
     * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
     */
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int columnStart = 0;
        int columnEnd = matrix[0].length - 1;

        while(rowStart <= rowEnd && columnStart <= columnEnd) {
            // go right
            for(int column = columnStart; column <= columnEnd; column++) {
                result.add(matrix[rowStart][column]);
            }

            // go down
            for(int row = rowStart + 1; row <= rowEnd; row++) {
                result.add(matrix[row][columnEnd]);
            }

            /**
             * Here we only go up until while rowStart < rowEnd
             * that is because when you have only 1 row left... that is when we are at the
             * outer rowStart == rowEnd then we still have to advance from left to right.
             * But we don't go backwards because we already visited the entire row
             */
            if(rowStart < rowEnd && columnStart < columnEnd) {
                // go left
                for(int column = columnEnd - 1; column >= columnStart; column--) {
                    result.add(matrix[rowEnd][column]);
                }

                // go right
                for(int row = rowEnd - 1; row > rowStart; row--) {
                    result.add(matrix[row][columnStart]);
                }
            }
            rowStart++;
            rowEnd--;
            columnStart++;
            columnEnd--;
        }

        return result;
    }
}
