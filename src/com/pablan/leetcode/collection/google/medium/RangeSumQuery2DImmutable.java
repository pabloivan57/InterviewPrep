package com.pablan.leetcode.collection.google.medium;

public class RangeSumQuery2DImmutable {

    int[][] sum;

    /**
     *  Pablo's notes: Look at the picture
     *  https://leetcode.com/problems/range-sum-query-2d-immutable/discuss/572648
     *
     *  But let's go step by step, imagine array
     *
     *  1 2 3
     *  4 5 6
     *  7 8 9
     *
     *  let's have sums rrow by row starting by 1
     *
     *  1 3 6
     *
     *  No let's go at row 2
     *
     *  4 9 15
     *
     *  If you want to compute matrix sum simply add the sums of the row above index and also sums of current row.
     *  Imagine index 1, 1
     *
     *  we know we have to sum 1, 2, 4, 5. So let's use the aggregations. We have 0, 1 which already summed 1 + 2
     *  And we have 1, 1 which already summed 4, 5. In other words we have 9 + 3
     *
     *  1 3 6
     *  4 9 15 --> for 1,1 we have to sum 9 + 3 = 12. Perfect, but now imagine you're the computer and only have calculated
     *
     *  1 3 6 and now you go for row 1, you find number 3 and apply the same algorithm, Aggregation of row above (1)  (row - 1, column)
     *  + aggregation of current row (4) (row, column - 1). In other words 5. Now you have the following grid
     *
     *  1 3  6
     *  5 13
     *
     *  But 13 is incorrect, why is this? That's because you summed 1 twice (1 + 2) amd (1 + 4). So yo correct this we have to remove
     *  1 or (row - 1, column -1) (3 + 5 + 5 - 1) = 12
     *
     *  1  3   6
     *  5  12  21
     *  12 27  45
     *
     *  Now for the ranges, you have a matrix that has cummulative sums. But If you look at the picture in the link
     *  let's image this example with that.
     *
     *  1 2 3
     *  4 5 6
     *  7 8 9
     *
     *   Now, we are asked to sum
     *
     *   5 6
     *   8 9
     *
     *   Since position 3, 3 or 9 in the cummulative sums represents sum of everything. Then we can reverse engineer
     *   the sum and say that (sum of everything) - row before the row (5 6) = 6 - col before col 5 = 12
     *                                                                                            8
     *   plus sum of row1 - 1, col1 - 1  because you substracted that twice. Is the result
     *   
     *   45 - 6 - 12 + 1 = 28 == 5 + 6 + 8+ 9
     */
    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m + 1][n + 1]; // sum[i][j] is sum of all elements from rectangle (0,0,i,j) as left, top, right, bottom corresponding
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++; col1++; row2++; col2++; // Since `sum` start with 1 so we need to increase r1, c1, r2, c2 by 1
        return sum[row2][col2] - sum[row2][col1 - 1] - sum[row1 - 1][col2] + sum[row1 - 1][col1 - 1];
    }
}
