package com.pablan.leetcode.collection.google.hard;

import java.util.HashSet;
import java.util.Stack;

public class MaximumRectangle {

    /**
     *  Given a 2D binary matrix filled with 0's and 1's,
     *  find the largest rectangle containing only 1's and return its area.
     *
     * Example:
     *
     * Input:
     * [
     *   ["1","0","1","0","0"],
     *   ["1","0","1","1","1"],
     *   ["1","1","1","1","1"],
     *   ["1","0","0","1","0"]
     * ]
     * Output: 6
     *
     * Pablo's notes: Explanation is at the bottom of
     * https://tech.pic-collage.com/algorithm-largest-area-in-histogram-84cc70500f0c
     *
     * But basically, imagine the 1's create histograms. just look at the first row
     * 1 is * and 0 is nothing. The histogram would look like
     *
     * * _ * _ _
     *
     * With row two now we have
     *
     * *   *
     * * _ * * *
     *
     * and so one, row 3 for example is
     *
     * *   *
     * *   * * *
     * * * * * *
     *
     * !!! Important:
     *
     * An easy way to calculate those histograms is to sum all 1's from top to bottom
     * if you see a 0 then... everything becomes 0. For example
     *
     * 1
     * 0
     * 1  should be *
     * 1            *
     *
     * so we go with first row. 1, great height is 1, we go to row two... it's a 0. Then height is 0. Go to
     * row 3, height is 1. Go to row 4 height is 2... which is what the histogram wanted
     */
    public int maximalRectangle(char[][] matrix) {
        int[] histogram = new int[matrix.length];

        int maxArea = Integer.MIN_VALUE;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                if(matrix[row][col] == '0') {
                    histogram[col] = 0;
                } else {
                    histogram[col]++;
                }

                // calculate max rectangle histogram.
                maxArea = Math.max(maxArea, largestRectangleHistogram(histogram));
            }
        }

        return maxArea;
    }

    /**
     *  Refer to LargestRectangleHistogram for this algorithm
     */
    private int largestRectangleHistogram(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int maxArea = Integer.MIN_VALUE;
        while(i < arr.length) {
            if(stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.push(i);
                i++;
            } else {
                int previousMaxValIndex = stack.pop();
                int previousMaxValValue = arr[previousMaxValIndex];
                int distance = stack.isEmpty() ? i :  i - (stack.peek() + 1);
                int localArea = distance * previousMaxValValue;

                maxArea = Math.max(maxArea, localArea);
            }
        }

        // if stack has something then this is an ascending sequence
        int n = arr.length;
        while(!stack.isEmpty()) {
            int previousMaxValIndex = stack.pop();
            int previousMaxValValue = arr[previousMaxValIndex];
            int distance = stack.isEmpty() ? n :  n - (stack.peek() + 1);
            int localArea = distance * previousMaxValValue;

            maxArea = Math.max(maxArea, localArea);
        }

        return maxArea;
    }
}
