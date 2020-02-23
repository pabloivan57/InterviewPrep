package com.pablan.leetcode.collection.google;

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
     * Pablo's notes: Greedy approach, just check 1 A element against everything or 2 B against everything
     */
    public int minDominoRotations(int[] A, int[] B) {
        int rotations = check(A[0], A, B);

        if(rotations != -1 || A[0] == B[0]) {
            return rotations;
        }

        return check(B[0], A, B);
    }

    public int check(int target, int[] A, int[] B) {

        int rotations_A = 0;
        int rotations_B = 0;

        // The point of this method is to calculate how many rotations would you need in row A or row B
        // to make all numbers equal
        for(int i = 1; i < A.length; i++) {
            if(A[i] != target && B[i] != target) {
                return -1;
            }

            // If we reach this point we are saying that one value must be equal at target
            else if(A[i] != target) {
                rotations_A++;
            } else if(B[i] != target) {
                rotations_B++;
            }
        }

        return Math.min(rotations_A, rotations_B);
    }
}
