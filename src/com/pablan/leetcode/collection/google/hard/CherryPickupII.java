package com.pablan.leetcode.collection.google.hard;

import java.util.LinkedList;
import java.util.Queue;

public class CherryPickupII {

    /**
     * Given a rows x cols matrix grid representing a field of cherries.
     * Each cell in grid represents the number of cherries that you can collect.
     *
     * You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0) ,
     * and Robot #2 is located at the top-right corner (0, cols-1) of the grid.
     *
     * Return the maximum number of cherries collection using both robots  by following the rules below:
     *
     * From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
     * When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
     * When both robots stay on the same cell, only one of them takes the cherries.
     * Both robots cannot move outside of the grid at any moment.
     * Both robots should reach the bottom row in the grid.
     *
     * Input: grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
     *
     * 3 1 1
     * 2 5 1
     * 1 5 5
     * 2 1 1
     *
     * Output: 24
     * Explanation: Path of robot #1 and #2 are described in color green and blue respectively.
     * Cherries taken by Robot #1, (3 + 2 + 5 + 2) = 12.
     * Cherries taken by Robot #2, (1 + 5 + 5 + 1) = 12.
     * Total of cherries: 12 + 12 = 24.
     *
     * Pablo's notes: This problem is very intuitive once you think about it a little more
     * 1.- Robots move one row downwards at each step, that means that at each step you have a limited set of ~ around
     * 6 moves. For example If you are in row 2
     *
     * 2 5 1  robots can be in the following positions
     *
     * r1 5 r2,  r1 5 r2, 2 r1 r2, 2 r1 r2 1, r1 r2 1
     *
     * The above can be represented as
     *
     * row[] robot1Col[] robot2Col. For example r1 5 r2 would be
     * [1][0][2] , row 1 --> robot1 col 0 --> robot 2 col 2
     *
     * in the case of 2 r1 r2 1
     * [1][1][1], row 1 --> robot1 col == robot2 col => in other words pick any value c1 or c2
     *
     * you keep going until you reach the bottom and you select the max cherries for bottom row. And keep
     * working backwards.
     *
     * Look at the code below, the only thing that is left is memorizing the results
     *
     */
    public int cherryPickup(int[][] grid) {
        return dfs(grid, grid.length, 0, 0, grid[0].length);
    }

    private int dfs(int[][] grid, int gridRows,  int row, int rCol1, int rCol2) {
        if(row == gridRows) {
            return 0; // I went beyond board, can't pickup cherries
        }

        // generate each possibility
        int levelCherries = 0;
        for(int i = -1; i < 1; i++) {
            for(int j = -1; j < 1; j++) { // this nested loop is just to generate all possibilities between rCol1, rCol2
                                          // let's say I pick col1 + 1, robot two can go to col2 - 1, col2 or col2 + 1
                int nextRCol1 = rCol1 + i;
                int nextRCol2 = rCol2 + j;
                if(nextRCol1 > 0 && nextRCol1 < grid[0].length && nextRCol2 > 0 && nextRCol2 < grid[0].length) {
                    levelCherries = Math.max(levelCherries, dfs(grid, gridRows, row + 1, rCol1 + i, rCol2 + j));
                }

            }
        }

        int answer = 0;
        if(rCol1 == rCol2) {
            answer = grid[row][rCol1] + levelCherries;
        } else {
            answer = grid[row][rCol1]+ grid[row][rCol1] + levelCherries;
        }

        return answer;
    }
}
