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
     * Pablo's notes: https://www.youtube.com/watch?v=VNbkzsnllsU. Update, scratch that
     * this is a much better explanation: https://tech.pic-collage.com/algorithm-largest-area-in-histogram-84cc70500f0c
     *
     * However, not exactly translated the same way it's shown in here. The idea is to use a stack
     * to keep track of potential new rectangles that might be larger
     *
     * So, let's start right here
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> positions = new Stack<>();

        int i = 0;
        int maxArea = 0;
        while(i < heights.length) {
            if(positions.isEmpty() || heights[positions.peek()] < heights[i]) {
                positions.push(i);
                i++;
            } else {
                int prevBiggerNumberIndex = positions.pop();

                int distance = 0;
                if(positions.isEmpty()) {
                    // this means there are no values with less than this height
                    // so current height applies until the beginning
                    distance = i;
                } else {
                    distance = i - prevBiggerNumberIndex;
                }

                int height = heights[prevBiggerNumberIndex];
                int area = distance * height;

                maxArea = Math.max(maxArea, area);
            }
        }

        // at this point if the stack has something it will be an ascending bar
        while(!positions.isEmpty()) {
            int prevBiggerNumberIndex = positions.pop();

            int distance = 0;
            if(positions.isEmpty()) {
                // this means there are no values with less than this height
                // so current height applies until the beginning
                distance = i;
            } else {
                distance = i - prevBiggerNumberIndex;
            }
            int height = heights[prevBiggerNumberIndex];
            int area = distance * height;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
