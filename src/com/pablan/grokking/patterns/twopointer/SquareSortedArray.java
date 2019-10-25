package com.pablan.grokking.patterns.twopointer;

public class SquareSortedArray {

    public int[] makeSquares(int[] arr) {

        int[] result = new int[arr.length];
        int maxSquareIndex = arr.length - 1;
        int leftPtr = 0;
        int rightPtr = arr.length - 1;

        while(leftPtr <= rightPtr) {
            int leftSquare = arr[leftPtr] * arr[leftPtr];
            int rightSquare = arr[rightPtr] * arr[rightPtr];

            if (leftSquare > rightSquare) {
                result[maxSquareIndex] = leftSquare;
                leftPtr++;
            } else {
                result[maxSquareIndex] = rightSquare;
                rightPtr--;
            }

            maxSquareIndex--;
        }

        return result;
    }
}
