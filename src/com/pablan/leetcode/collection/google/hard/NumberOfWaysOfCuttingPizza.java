package com.pablan.leetcode.collection.google.hard;

public class NumberOfWaysOfCuttingPizza {

    /**
     *  Given a rectangular pizza represented as a rows x cols matrix
     *  containing the following characters: 'A' (an apple) and '.' (empty cell) and given the integer k.
     *  You have to cut the pizza into k pieces using k-1 cuts.
     *
     *  For each cut you choose the direction: vertical or horizontal, then you choose a cut position at the
     *  cell boundary and cut the pizza into two pieces. If you cut the pizza vertically, give the left part of the
     *  pizza to a person. If you cut the pizza horizontally, give the upper part of the pizza to a person.
     *  Give the last piece of pizza to the last person.
     *
     *  Return the number of ways of cutting the pizza such that each piece contains at least one apple.
     *  Since the answer can be a huge number, return this modulo 10^9 + 7.
     *
     *  Pablo's notes: The trick to understand this problem is that he build a table with sums of apples from
     *  bottom to top. For example
     *
     *  A . .
     *  A A A
     *  . . .
     *
     *  Starting from the bottom corner if you start expanding a box from bottom row, bottom col to row, col you get something like this
     *
     *  start a pos (3,3), 0 apples
     *  go to pos (3, 2) how many apples I have in box 3,2 --> 3,3 ? 0
     *  now try pos (2, 3) how many apples I have in bow 2, 3 --> 4, 4 ? 1
     *  perfect, my grid now looks like this. * means I don't know yet
     *
     *  * * *
     *  * * 1
     *  * 0 0
     *
     *  go to post (2, 2) how many apples I have in box 2, 2 --> 3, 3 ? 2
     *
     *  * * *
     *  * 2 1
     *  * 0 0
     *
     *  and you go until you finish
     *
     *  4 2 1
     *  3 2 1
     *  0 0 0
     *
     *  Here's where the algorithm begins. Let' say you are at position 0, 0 and you want to cut row 1, 0
     *  4 - 3. Will the top have at least 1 apple? Yes... cool then split and keep going
     *
     *  Now let's deal with what we have left
     *
     *  3 2 1
     *  0 0 0
     *  If you cut next then you end up with 3 - 2. Yes... cool then you have another way. But
     *  youre' left with 0, 0. That's the base case. You don't have apples. Therefore you can't cut like this
     *  return 0
     */
    public int ways(String[] pizza, int k) {
        int m = pizza.length, n = pizza[0].length();
        Integer[][][] dp = new Integer[k][m][n];
        int[][] preSum = new int[m+1][n+1]; // preSum[r][c] is the total number of apples in pizza[r:][c:]
        for (int r = m - 1; r >= 0; r--)
            for (int c = n - 1; c >= 0; c--)
                preSum[r][c] = preSum[r][c+1] + preSum[r+1][c] - preSum[r+1][c+1] + (pizza[r].charAt(c) == 'A' ? 1 : 0);
        return dfs(m, n, k-1, 0, 0, dp, preSum);
    }

    int dfs(int m, int n, int k, int r, int c, Integer[][][] dp, int[][] preSum) {
        if (preSum[r][c] == 0) return 0; // if the remain piece has no apple -> invalid
        if (k == 0) return 1; // found valid way after using k-1 cuts
        if (dp[k][r][c] != null) return dp[k][r][c];
        int ans = 0;
        // cut in horizontal
        for (int nr = r + 1; nr < m; nr++)
            if (preSum[r][c] - preSum[nr][c] > 0) // cut if the upper piece contains at least one apple
                ans = (ans + dfs(m, n, k - 1, nr, c, dp, preSum)) % 1_000_000_007;
        // cut in vertical
        for (int nc = c + 1; nc < n; nc++)
            if (preSum[r][c] - preSum[r][nc] > 0) // cut if the left piece contains at least one apple
                ans = (ans + dfs(m, n, k - 1, r, nc, dp, preSum)) % 1_000_000_007;
        return dp[k][r][c] = ans;
    }
}
