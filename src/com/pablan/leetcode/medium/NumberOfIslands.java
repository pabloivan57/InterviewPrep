package com.pablan.leetcode.medium;

public class NumberOfIslands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     *
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     *
     * Output: 1
     */
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int columns = grid[0].length;
        int numIslands = 0;

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(grid[row][column] == '1') {
                    //trigger dfs
                    numIslands++;
                    dfs(grid, row, column);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int row, int column) {
        int rows = grid.length;
        int columns = grid[0].length;

        // out of bounds check
         if(row < 0 || column < 0 || row >= rows || column >= columns || grid[row][column] == '0') {
             return;
         }

         // visit node
         grid[row][column] = '0';

         //right
         dfs(grid, row + 1, column);
         //left
         dfs(grid, row - 1, column);
         //up
         dfs(grid, row, column - 1);
         //down
         dfs(grid, row, column + 1);
    }
}
