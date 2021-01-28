package com.pablan.leetcode.collection.google.hard;

public class TilingARectangleWithFewestSquares {

    /**
     * Given a rectangle of size n x m, find the minimum number of integer-sided squares that tile the rectangle.
     *
     * Input: n = 2, m = 3
     * Output: 3
     * Explanation: 3 squares are necessary to cover the rectangle.
     * 2 (squares of 1x1)
     * 1 (square of 2x2)
     *
     * Example 2:
     *
     * Input: n = 5, m = 8
     * Output: 5
     *
     * Example 3:
     *
     * Input: n = 11, m = 13
     * Output: 6
     *
     * Pablo's notes: This problem is VERY hard and there have been papers about it
     * there is no way you will deduct something like this. So the only option
     * you have is to memorize the solution
     */
    public int tilingRectangle(int n, int m) {
        int area = n * m;

        return tilingRectangle(0, n, area, 0);
    }

    public int tilingRectangle(int square, int n, int area, int squares) {
        int coveredArea = square * square;

        if(coveredArea > area) {
            return Integer.MAX_VALUE;
        }

        if(coveredArea == area) {
            return squares;
        }

        int minSquares = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int tilingOption = tilingRectangle(i, n, area - coveredArea, squares + 1);
            minSquares = Math.min(minSquares, tilingOption);
        }

        return minSquares;
    }
}
