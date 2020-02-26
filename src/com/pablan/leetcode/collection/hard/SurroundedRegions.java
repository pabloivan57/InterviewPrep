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
        for(int row = 0 ; row < board.length; row++) {
            for(int column = 0; column < board[0].length; column++) {
                if(board[row][column] == 'O' && isBorder(row, column, board)) {
                    // start a dfs here
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    dfs(row, column, visited, board);
                }
            }
        }

        // flip everything to X except special character
        for(int row = 0 ; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if(board[row][column] == '*') {
                    board[row][column] = 'O';
                } else {
                    board[row][column] = 'X';
                }
            }
        }
    }

    private void dfs(int row, int column, boolean visited[][], char[][] board) {
        // If it's out of limits or visited
        if(row < 0 || row >= board.length || column < 0 || column >= board[0].length || visited[row][column] || board[row][column] == 'X') {
            return;
        }

        // Visit
        visited[row][column] = true;

        if(board[row][column] == 'O') {
            board[row][column] = '*';
        }

        // dfs
        // down
        dfs(row + 1, column, visited, board);
        // up
        dfs(row - 1, column, visited, board);
        // left
        dfs(row, column - 1, visited, board);
        // right
        dfs(row, column + 1, visited, board);
    }

    private boolean isBorder(int row, int column, char[][] board) {
        if(row == 0 || row == board.length - 1 || column == 0 || column == board[0].length - 1) {
            return true;
        }

        return false;
    }
}
