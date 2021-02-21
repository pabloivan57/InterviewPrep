package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class AlphabetBoard {

    /**
     * On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].
     *
     * Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
     *
     * abcde
     * fghij
     * klmno
     * pqrst
     * uvwxy
     * z
     *
     * We may make the following moves:
     *
     * 'U' moves our position up one row, if the position exists on the board;
     * 'D' moves our position down one row, if the position exists on the board;
     * 'L' moves our position left one column, if the position exists on the board;
     * 'R' moves our position right one column, if the position exists on the board;
     * '!' adds the character board[r][c] at our current position (r, c) to the answer.
     * (Here, the only positions that exist on the board are positions with letters on them.)
     *
     * Return a sequence of moves that makes our answer equal to target in the minimum number of moves.
     * You may return any path that does so.
     *
     * Example 1:
     *
     * Input: target = "leet"
     * Output: "DDR!UURRR!!DDD!"
     * Example 2:
     *
     * Input: target = "code"
     * Output: "RR!DDRR!UUL!R!"
     *
     * 0,0 -> 2, 1 ==> At any point in time this will give me two options, reach through x or through
     *
     * 2 - 0 = 2
     * 1 - 0 = 1     Or
     *
     * DDR!                  RDD!
     *
     * 2, 1 -> 0, 4
     *
     * 0 - 2 = -2
     * 4 - 1 = 3      Or
     *
     * UURRR!               RRRUU!
     *
     * 0,4 -> 0, 4
     *
     * 0 - 0 = 0
     * 4 - 4 = 0
     * !
     * .
     * .
     * .
     *
     */
    private char[][] board = new char[][] {
            {'a', 'b', 'c', 'd','e'},
            {'f', 'g', 'h', 'j', 'i'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z', '0', '0', '0', '0'}
    };

    public String alphabetBoardPath(String target) {

        Map<Character, int[]> charPositions = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(Character.isLetter(board[i][j])) {
                    charPositions.put(board[i][j], new int[] {i, j});
                }
            }
        }

        Stack<BoardPosition> dfsStack = new Stack<>();
        dfsStack.add(new BoardPosition(0, 0, 0, ""));

        while(!dfsStack.isEmpty()) {
            BoardPosition currentPosition = dfsStack.pop();

            // If I reached the end of the word, return it. Any sequence works
            if(currentPosition.targetIndex == target.length()) {
                return currentPosition.sequence;
            }

            char nextLetter = target.charAt(currentPosition.targetIndex);
            int[] nextPosition = charPositions.get(nextLetter);

            int deltaRow = nextPosition[0] - currentPosition.row;
            int deltaCol = nextPosition[1] - currentPosition.column;

            char directionX = deltaRow < 0 ? 'U' : 'D';
            char directionY = deltaCol < 0 ? 'L' : 'R';

            deltaRow = Math.abs(deltaRow);
            deltaCol = Math.abs(deltaCol);

            String optionComponentX = "";
            for(int i = 0; i < deltaRow; i++) {
                optionComponentX += directionX;
            }

            String optionComponentY = "";
            for(int j = 0; j < deltaCol; j++) {
                optionComponentY += directionY;
            }

            // add two new options to stack
            dfsStack.add(new BoardPosition(nextPosition[0], nextPosition[1], currentPosition.targetIndex + 1, currentPosition.sequence + optionComponentX + optionComponentY + "!"));
            dfsStack.add(new BoardPosition(nextPosition[0], nextPosition[1], currentPosition.targetIndex + 1, currentPosition.sequence + optionComponentY + optionComponentX + "!"));

        }

        return "";
    }

    private class BoardPosition {
        int row;
        int column;
        int targetIndex;
        String sequence;

        public BoardPosition(int row, int column, int targetIndex, String sequence) {
            this.row = row;
            this.column = column;
            this.targetIndex = targetIndex;
            this.sequence = sequence;
        }
    }
}
