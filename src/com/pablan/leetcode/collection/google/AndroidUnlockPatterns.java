package com.pablan.leetcode.collection.google;

public class AndroidUnlockPatterns {

    /**
     * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of
     * unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
     *
     * Rules for a valid pattern:
     *
     * Each pattern must connect at least m keys and at most n keys.
     * All the keys must be distinct.
     * If the line connecting two consecutive keys in the pattern passes through any other keys,
     * the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
     * The order of keys used matters.
     *
     * Explanation:
     *
     * | 1 | 2 | 3 |
     * | 4 | 5 | 6 |
     * | 7 | 8 | 9 |
     *
     * Invalid move: 4 - 1 - 3 - 6
     * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
     *
     * Invalid move: 4 - 1 - 9 - 2
     * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
     *
     * Valid move: 2 - 4 - 1 - 3 - 6
     * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
     *
     * Valid move: 6 - 5 - 4 - 1 - 9 - 2
     * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
     *
     * Example 1:
     *
     * Input: m = 1, n = 1
     * Output: 9
     * Example 2:
     *
     * Input: m = 1, n = 2
     * Output: 65
     *
     * Pablo's notes: This problem seems to be like you need a generic brute force...
     * but you can take advantage that the grid has always 9 numbers. Here is how
     * you will keep track of an array called 'jumps' that means "From number row to col which numbers
     * should I visit first so that I can make that jump?"
     *
     * Now let's imagine the grid
     *                             0  1  2  3  4....
     *     1  2  3             0   0
     *     4  5  6   ==        1   1
     *     7  8  9             2   0
     *                         .   .
     *                         .   .
     *                         .   .
     *                         7   4
     *                  This means that to go from pos 1 to 7 I need to have visited 4 first
     *
     *   If you have that table, then we can generate for each number all the possibilities and check
     *   if we have the requisites. For example:
     *   Start at 1, I can go to 2, 3 (only if I have 2 visited), 4, 5, 6 (Because we don't pass through any number here),
     *   7 (only if I visited 4 first), 8, 9 (only If I visited 5) first.
     *
     *   Do this with each number
     */
    public int numberOfPatterns(int m, int n) {
        int[][] jumps = new int[10][10];
        // left to right
        jumps[1][3] = jumps[3][1] = 2;
        jumps[4][6] = jumps[6][4] = 5;
        jumps[7][9] = jumps[9][7] = 8;
        // up to down
        jumps[1][7] = jumps[7][1] = 4;
        jumps[2][8] = jumps[8][2] = 5;
        jumps[3][9] = jumps[9][3] = 6;
        // diagonals
        jumps[1][9] = jumps[9][1] = 5;
        jumps[7][3] = jumps[3][7] = 5;

        int count = 0;
        for(int i = 0; i < 9; i++) {
            boolean[] visited = new boolean[10];
            count += dfs(i, jumps, 0, 0, visited, m, n);
        }
        return count;
    }

    private int dfs(int number, int[][] jumps, int length, int count, boolean[] visited, int m, int n) {
        if(length > n) {
            return count;
        }

        if(length >= m) {
            count++;
        }

        // visit
        visited[number] = true;

        for(int i = 1; i < 9; i++) {
            // try jumping to every other number
            int requiredToJump = jumps[number][i];
            if(!visited[i] && (requiredToJump == 0 || visited[requiredToJump])) {
                count = dfs(i, jumps, length + 1, count, visited, m, n); // //count+=dfs is happening implicitly here as we are passing count returned from last call
            }
        }

        // backtrack
        visited[number] = false;
    }



}
