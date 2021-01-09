package com.pablan.leetcode.collection.google;

import java.util.Arrays;
import java.util.Map;

public class LongestIncreasingPathMatrix {

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
    // up, down, left, right
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], - 1);
        }

        int maxPath = -1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                maxPath = Math.max(maxPath, dfs(i, j, matrix, visited, -1, 0, dp));
            }
        }
        
        return maxPath;
    }

    private int dfs(int row, int column,int[][] matrix, boolean visited[][], int parent, int pathCount, int[][] dp) {
        if(row < 0
                || row >= matrix.length
                || column < 0
                || column >= matrix[0].length
                || visited[row][column]
                || parent > matrix[row][column]) {
            return pathCount;
        }

        if(dp[row][column] != -1) {
             return dp[row][column] + pathCount;
        }

        visited[row][column] = true;

        for(int i = 0; i < directions.length; i++) {
            int[] direction = directions[i];
            dp[row][column] = Math.max(dp[row][column],
                    dfs(row + direction[0], column + direction[1], matrix, visited, matrix[row][column], pathCount + 1, dp));
        }

        // backtrack
        visited[row][column] = false;
        return dp[row][column];
    }
}
