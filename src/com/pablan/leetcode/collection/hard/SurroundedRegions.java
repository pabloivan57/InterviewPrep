package com.pablan.leetcode.collection.hard;

public class SurroundedRegions {

    /**
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     *
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     *
     * Example:
     *
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     *
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     *
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border
     * of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O'
     * on the border will be flipped to 'X'.
     *
     * Two cells are connected if they are adjacent cells connected horizontally or vertically.
     *
     * Pablo's notes: This turned out to be like the flooding water problem. start at the sea, borders
     * if it's water then start dfs looking for 0, if 0 change it to special character and at the end
     * we just flip everything to X and if we see the special character we flip it to 'O'
     */
    public void solve(char[][] board) {

    }

    private void dfs(int row, int column, boolean visited[][], char[][] board) {
     return;
    }
}
