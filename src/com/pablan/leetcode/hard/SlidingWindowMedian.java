package com.pablan.leetcode.hard;

import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;

    /**
     * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
     *
     * Examples:
     * [2,3,4] , the median is 3
     *
     * [2,3], the median is (2 + 3) / 2 = 2.5
     *
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.
     *
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     *
     * Window position                Median
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       1
     *  1 [3  -1  -3] 5  3  6  7       -1
     *  1  3 [-1  -3  5] 3  6  7       -1
     *  1  3  -1 [-3  5  3] 6  7       3
     *  1  3  -1  -3 [5  3  6] 7       5
     *  1  3  -1  -3  5 [3  6  7]      6
     * Therefore, return the median sliding window as [1,-1,-1,3,5,6].
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        low = new PriorityQueue<>((a, b) -> b - a);
        high = new PriorityQueue<>((a, b) -> a - b);
        double[] result = new double[nums.length - k + 1];

        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if(windowEnd < k - 1) {
                addNumber(nums[windowEnd]);
                continue;
            }
            addNumber(nums[windowEnd]);
            result[windowStart] = findMedian();
            removeNumber(nums[windowStart++]);
        }

        return result;
    }

    private void removeNumber(Integer a) {
        // Remove number
        if(!low.remove(a)) {
            high.remove(a);
        }

        // Rebalance
        if(high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    private void addNumber(Integer a) {
        low.offer(a);
        high.offer(low.poll());

        // Rebalance
        if(high.size() > low.size()) {
            low.offer(high.poll());
        }
    }

    private double findMedian() {
        return low.size() > high.size() ? low.peek() : (low.peek() + high.peek()) / 2.0;
    }
}
