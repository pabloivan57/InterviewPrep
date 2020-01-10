package com.pablan.leetcode.medium;

public class SetMatrixZeros {

    /**
     * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
     *
     * Example 1:
     *
     * Input:
     * [
     *   [1,1,1],
     *   [1,0,1],
     *   [1,1,1]
     * ]
     * Output:
     * [
     *   [1,0,1],
     *   [0,0,0],
     *   [1,0,1]
     * ]
     * Example 2:
     *
     * Input:
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * Output:
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * Follow up:
     *
     * A straight forward solution using O(mn) space is probably a bad idea.
     * A simple improvement uses O(m + n) space, but still not the best solution.
     * Could you devise a constant space solution?
     *
     * Pablo's notes: 2 solutions, 2nd one is clever
     *
     * 1) Common sense, the problem when you change the whole column - row to 0's is that
     * you still have to iterate each element, and that might confuse your algorithm changing the whole
     * row/ column from one of the new zeroes are not supposed to. To overcome this problem, we choose another
     * flag to mark cells that will have to be change to 0 later (-1000 for example). Later we iterate again the
     * matrix and modify all the zeroes
     *
     * 2) An improvement on one, the problem before is that while setting -1000 the cell can be visited multiple times
     * when it's not really needed to. What is clever about this approach is that it just 'takes note' of the rows
     * and columns that have to be changed by marking [i][0] and [j][0]. Then we just iterate again over the matrix
     * and check if [i][0] or [j][0] == '0'. If that's the case then we proceed to make the cell 0
     */
    public void setZeroes(int[][] matrix) {


    }
}
