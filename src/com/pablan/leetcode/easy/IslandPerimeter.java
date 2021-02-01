package com.pablan.leetcode.easy;

public class IslandPerimeter {

    /**
     * You are given row x col grid representing a map where grid[i][j] = 1
     * represents land and grid[i][j] = 0 represents water.
     *
     * Grid cells are connected horizontally/vertically (not diagonally).
     * The grid is completely surrounded by water, and there is exactly one island
     * (i.e., one or more connected land cells).
     *
     * The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island.
     * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
     * Determine the perimeter of the island.
     *
     * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
     * Output: 16
     * Explanation: The perimeter is the 16 yellow stripes in the image above.
     * Example 2:
     *
     * Input: grid = [[1]]
     * Output: 4
     * Example 3:
     *
     * Input: grid = [[1,0]]
     * Output: 4
     */
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for(int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    perimeter = dfs(row, col, grid, visited);
                }
            }
        }

        return perimeter;
    }

    public int dfs(int row, int col, int[][] grid, boolean[][] visited) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 1;
        }

        if(visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;

        int perimeter = 0;
        perimeter += dfs(row - 1, col, grid, visited);
        perimeter += dfs(row + 1, col, grid, visited);
        perimeter += dfs(row, col - 1, grid, visited);
        perimeter += dfs(row, col + 1, grid, visited);

        return perimeter;
    }
}
