package com.pablan.leetcode.medium;

public class WordSearch {

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent"
     * cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     *
     * Example:
     *
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * Given word = "ABCCED", return true.
     */
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                boolean[][] visited = new boolean[board.length][board[0].length];

                if(dfs(board, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, boolean visited[][], int row, int column, int wordIndex, String word) {
        if(wordIndex == word.length() - 1) return true;

        int rows = board.length;
        int columns = board[0].length;

        if(row < rows || column < column || row >= rows || column >= columns || visited[row][column] == true) {
            return false;
        }

        if(board[row][column] != word.charAt(wordIndex)) {
            return false;
        } else {
            visited[row][column] = true;

            boolean result = false;

            // Up
            result = result || dfs(board, visited, row - 1, column, wordIndex + 1, word);
            // Down
            result = result || dfs(board, visited, row + 1, column, wordIndex + 1, word);
            // Left
            result = result || dfs(board, visited, row, column - 1, wordIndex + 1, word);
            // Right
            result = result || dfs(board, visited, row, column + 1, wordIndex + 1, word);

            return result;
        }
    }
}
