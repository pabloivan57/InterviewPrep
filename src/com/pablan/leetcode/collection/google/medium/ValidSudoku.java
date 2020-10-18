package com.pablan.leetcode.collection.google.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /**
     * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be
     * validated according to the following rules:
     *
     * Each row must contain the digits 1-9 without repetition.
     * Each column must contain the digits 1-9 without repetition.
     * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     *
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     *
     * Input: board =
     * [["5","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     *
     * Output: true
     *
     * Example 2:
     *
     * Input: board =
     * [["8","3",".",".","7",".",".",".","."]
     * ,["6",".",".","1","9","5",".",".","."]
     * ,[".","9","8",".",".",".",".","6","."]
     * ,["8",".",".",".","6",".",".",".","3"]
     * ,["4",".",".","8",".","3",".",".","1"]
     * ,["7",".",".",".","2",".",".",".","6"]
     * ,[".","6",".",".",".",".","2","8","."]
     * ,[".",".",".","4","1","9",".",".","5"]
     * ,[".",".",".",".","8",".",".","7","9"]]
     * Output: false
     * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8.
     * Since there are two 8's in the top left 3x3 sub-box, it is invalid.
     *
     * Pablo's notes: First of all, you will notice 3 rules
     * 1.- Check if the number has not appeared in the row
     * 2.- Check if the number has not appeared in the column
     * 3.- Check if the number has not appeared in the block
     *
     * 3 has a further explanation. First, we can find the block by dividing row and column by 3
     * makes sense huh? if something is at index 9, 9 because we are splitting in boxes of 3 then
     * it will be in box position 2,2 (because we are 0 indexed... that is actually box 9),
     * Another example, (8,8) --> 8 / 3 = 2. Still block 2,2
     *
     * Also, this will help you understand the transformations, not quite this use case but help:
     *
     * "Case anybody still wonders where the formula (i / 3) * 3 + j / 3 comes from, this is a variation of the
     * standard conversion that compilers already make to access data in 2D arrays.
     * Internally, a 2D array (NxM) is a linear array of size N * M, therefore when we read a value A[i][j],
     * we are just accessing the element i * M + j of the linear representation.
     * In this problem we have inner 3x3 boxes inside a 9x9 grid, so we need to divide the coordinates by 3
     * to make sure each "box group" is mapped to the correct position in the linear frequency view"
     *
     * So, let's keep track of all of them
     */
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }

                String row = "row " + i + " " + board[i][j];
                String column = "column " + j + " " + board[i][j];
                String block = "block " + i / 3 + "," + j / 3 + " " + board[i][j];

                if(seen.contains(row) || seen.contains(column) || seen.contains(block)) {
                    return false;
                }

                seen.add(row);
                seen.add(column);
                seen.add(block);
            }
        }

        return true;
    }
}
