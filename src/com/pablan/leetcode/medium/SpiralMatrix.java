package com.pablan.leetcode.medium;

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

        int layers = matrix.length /  2;
        for(int i = 0; i < layers; i++) {
            int first = i;
            int last = matrix.length - first - 1;

            List<Integer> upperRow = new ArrayList<>();
            List<Integer> rightColumn = new ArrayList<>();
            List<Integer> lowerRow = new ArrayList<>();
            List<Integer> leftColumn = new ArrayList<>();

            for(int j = first; j < last; j++) {
                upperRow.add(matrix[i][first]);
                rightColumn.add(matrix[last][i]);
                lowerRow.add(matrix[last][last]);
                leftColumn.add(matrix[last][i]);
            }

            result.addAll(upperRow);
            result.addAll(rightColumn);
            result.addAll(lowerRow);
            result.addAll(leftColumn);
        }

        return result;
    }
}
