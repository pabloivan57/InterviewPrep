package com.pablan.leetcode.collection.google;

import java.util.Arrays;

public class LongestIncreasingPathMatrix {

    int maxPath = Integer.MIN_VALUE;
    /**
     * Given an integer matrix, find the length of the longest increasing path.
     *
     * From each cell, you can either move to four directions: left, right, up or down.
     * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
     *
     * Example 1:
     *
     * Input: nums =
     * [
     *   [9,9,4],
     *   [6,6,8],
     *   [2,1,1]
     * ]
     * Output: 4
     * Explanation: The longest increasing path is [1, 2, 6, 9].
     * Example 2:
     *
     * Input: nums =
     * [
     *   [3,4,5],
     *   [3,2,6],
     *   [2,2,1]
     * ]
     * Output: 4
     * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
     *
     */
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                bfs(i, j, Integer.MIN_VALUE, 0, visited, matrix);
            }
        }

        return maxPath;
    }

    public void bfs(int row, int column, int parent, int pathSize, boolean[][] visited, int[][] matrix) {
        if(row < 0
                || row >= matrix.length
                || column < 0
                || column >= matrix[0].length
                || visited[row][column]
            || parent >= matrix[row][column]) {
            maxPath = Math.max(maxPath, pathSize);
            return;
        }

        // visit
        visited[row][column] = true;

        bfs(row + 1, column, matrix[row][column], pathSize + 1, visited, matrix);
        bfs(row - 1, column, matrix[row][column], pathSize + 1, visited, matrix);
        bfs(row, column + 1, matrix[row][column], pathSize + 1, visited, matrix);
        bfs(row, column - 1, matrix[row][column], pathSize + 1, visited, matrix);
    }
}
