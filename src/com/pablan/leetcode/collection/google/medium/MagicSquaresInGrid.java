package com.pablan.leetcode.collection.google.medium;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {

    /**
     *  A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
     *
     *  Given a row x col grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
     *
     *  Example 1:
     *
     *  4 3 8 4
     *  9 5 1 9
     *  2 7 6 2
     *
     *  Input: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
     *  Output: 1
     *  Explanation:
     *  The following subgrid is a 3 x 3 magic square:
     *
     *  4 3 8
     *  9 5 1
     *  2 7 6
     *
     *  while this one is not
     *
     *  3 8 4
     *  5 1 9
     *  7 6 2
     *
     *  In total, there is only one magic square inside the given grid.
     *
     *  Example 2:
     *
     * Input: grid = [[8]]
     * Output: 0
     * Example 3:
     *
     * Input: grid = [[4,4],[3,3]]
     * Output: 0
     * Example 4:
     *
     * Input: grid = [[4,7,8],[9,5,1],[2,3,6]]
     * Output: 0
     *
     * Pablo's notes: This one has a trick that you must remember!
     * There are ways to do brute force but this is such a widely know that is not worth it
     *
     * Ok, so the explanation
     *
     * You have a grid
     *
     * x x x --> sum should be M
     * y y y --> sum should be M
     * z z z --> sum should be M
     *
     * We know that the grid has to have numbers 1 through 9
     * 1 + 2 + 3 + 4 + 5... = 45
     *
     * so we now know that 3M = 45 --> M = 15. Now...
     *
     * if you sum all lines going through the center you have
     *  \     /   |   - -
     *   \   /    |
     *  Or 4M --> M ==15 --> 60, but I double counted center 4 times. So let's say
     *  nums 1 to 9 = 45 + 3 * middle = 60
     *  3 * middle = 15
     *  middle = 5
     *
     *  Therefore when you find a 5, you simply check around it for 1 through 9.
     *
     *  BUT: there is another trick. Turn out the values have to be
     *  43816729 (clockwise or anticlockwise). In other words
     *
     *  4381672943816729 or 9276183492761834
     */

    public int numMagicSquaresInside(int[][] grid) {

        int magicSquares = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int column = 0; column < grid[0].length; column++) {
                if(grid[row][column] == 5) {
                    //check if it's magic square
                    if(isMagicSquare(grid, row, column)) {
                        magicSquares++;
                    }
                }
            }
        }

        return magicSquares;
    }

    private boolean isMagicSquare(int[][] grid, int row, int column) {
        if(row - 1 < 0
                || row + 1 >= grid.length
                || column - 1 < 0
                || column + 1 >= grid[0].length) {
            return false;
        }

        String digits = "" + grid[row - 1][column - 1] + grid[row - 1][column] + grid[row - 1][column + 1]
                + grid[row][column + 1] + grid[row + 1][column + 1] + grid[row + 1][column] + grid[row + 1][column - 1]
                + grid[row][column - 1];
        return "4381672943816729".contains(digits) || "9276183492761834".contains(digits);
    }
}
