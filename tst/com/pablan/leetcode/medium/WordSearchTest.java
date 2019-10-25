package com.pablan.leetcode.medium;

import org.junit.Test;

public class WordSearchTest {

    /**
     *  Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
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
    @Test
    public void test() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(wordSearch.exist(board, "ABCCED"));
        System.out.println(wordSearch.exist(board, "SEE"));
        System.out.println(wordSearch.exist(board, "ABCB"));
    }
}
