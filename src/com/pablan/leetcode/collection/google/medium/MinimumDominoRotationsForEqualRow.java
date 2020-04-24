package com.pablan.leetcode.collection.google.medium;

public class MinimumDominoRotationsForEqualRow {

    /**
     *  In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
     *  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
     *
     * We may rotate the i-th domino, so that A[i] and B[i] swap values.
     *
     * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
     *
     * If it cannot be done, return -1.
     *
     * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
     * Output: 2
     * Explanation:
     * The first figure represents the dominoes as given by A and B: before we do any rotations.
     * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
     *
     * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
     * Output: -1
     * Explanation:
     * In this case, it is not possible to rotate the dominoes to make one row of values equal.
     *
     * 1 <= A[i], B[i] <= 6
     * 2 <= A.length == B.length <= 20000
     *
     * Pablo's notes: Greedy approach, just check 1 A element against everything or 2 B against everything.
     * This approach goes better with my thought process. The idea is straight forward,
     * let's assume none of the numbers in top row starting from A[0] are equal to target, then rotations = A.length
     * of course if neither A or B match target you return -1
     */
    public int minDominoRotations(int[] A, int[] B) {
        int up = check(A[0], A, B);
        int down = check(B[0], A, B);

        // if we can match all in either side
        if(up == -1 && down == -1) return -1;
        if(up == - 1) return down;
        if(down == -1) return up;

        return Math.min(up, down);
    }

    public int check(int val, int[] A, int[] B) {
        int top = A.length;
        int bottom = B.length;

        for(int i = 0; i < A.length; i++) {
            // If we don't have a number in both sides we can't full fill
            if(A[i] != val && B[i] != val) {
                return -1;
            }

            if(A[i] == val) {
                // turns out I already have a number in place, now I just need top(A.length) - 1 rotations
                top--;
            }

            if(B[i] == val) {
                bottom--;
            }
        }

        return Math.min(top, bottom);
    }
}
