package com.pablan.leetcode.collection.google.medium;

public class MaxAreaIsland {

    /**
     *  Given a non-empty 2D array grid of 0's and 1's,
     *  an island is a group of 1's (representing land)
     *  connected 4-directionally (horizontal or vertical.)
     *  You may assume all four edges of the grid are surrounded by water.
     *
     *  Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
     *
     *  Example 1:
     *
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
     * Example 2:
     *
     * [[0,0,0,0,0,0,0,0]]
     * Given the above grid, return 0.
     * Note: The length of each dimension in the given grid does not exceed 50.
     */

    private int maxArea = 0;

    public int maxAreaOfIsland(int[][] grid) {
        maxArea = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1 && visited[i][j] == false) {
                    dfs(i, j, grid, visited);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if(row < 0
                || row >= grid.length
                || col < 0
                || col >= grid[0].length
                || grid[row][col] == 0
                || visited[row][col] == true) {
            return 0;
        }


        // visit
        visited[row][col] = true;

        // dfs
        int down = dfs(row + 1, col, grid, visited);
        int up =  dfs(row - 1, col, grid, visited);
        int left = dfs(row, col - 1, grid, visited);
        int right = dfs(row, col + 1, grid, visited);

        int currentArea = 1 + up + down + left + right;

        if(currentArea > maxArea) {
            maxArea = currentArea;
        }

        return currentArea;
    }
}
