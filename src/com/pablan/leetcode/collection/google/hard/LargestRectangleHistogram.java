package com.pablan.leetcode.collection.google.hard;

import java.util.Stack;

public class LargestRectangleHistogram {

    /**
     * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
     * find the area of largest rectangle in the histogram.
     *     v v
     *       *
     *     * *
     *     * *
     *     * *   *
     * *   * * * *
     * * * * * * *
     * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
     * The largest rectangle is shown in the shaded area, which has area = 10 unit.
     *
     * Example:
     *
     * Input: [2,1,5,6,2,3]
     * Output: 10
     *
     * Pablo's notes: https://www.youtube.com/watch?v=VNbkzsnllsU
     *
     * However, not exactly translated the same way it's shown in here. The idea is to use a stack
     * to keep track of potential new rectangles that might be larger
     *
     * So, let's start right here
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> positions = new Stack<>();

        int maxArea = 0;
        for(int i = 0; i <  heights.length; i++)  {
            int nextHeight = heights[i];

            while(heights[positions.peek()] > nextHeight) {
                // This means we have to evaluate the rectangle as possible max
                int currentPosition = positions.peek();
                int currentHeight = heights[positions.pop()];

                int prevPosition = positions.empty() ? -1 : positions.peek(); // If there is no previous minimum
                                                                              // then we have to consider all positions starting from 0
                                                                              // as part of the rectangle
                                                                              // Remember that if there is a minimum, it
                                                                              // will be evaluated next

                int localArea = currentHeight * (currentPosition - prevPosition - 1);

                maxArea = Math.max(maxArea, localArea);
            }

            positions.push(i);
        }

        return maxArea;
    }
}
