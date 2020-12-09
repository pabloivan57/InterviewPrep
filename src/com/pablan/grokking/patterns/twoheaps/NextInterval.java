package com.pablan.grokking.patterns.twoheaps;

import java.util.PriorityQueue;

public class NextInterval {

    /**
     * Next Interval (hard) #
     * Given an array of intervals, find the next interval of each interval.
     * In a list of intervals, for an interval ‘i’ its next interval ‘j’
     * will have the smallest ‘start’ greater than or equal to the ‘end’ of ‘i’.
     *
     * Write a function to return an array containing indices of the next interval
     * of each input interval. If there is no next interval of a given interval,
     * return -1. It is given that none of the intervals have the same start point.
     *
     * Example 1:
     *
     * Input: Intervals [[2,3], [3,4], [5,6]]
     * Output: [1, 2, -1]
     * Explanation: The next interval of [2,3] is [3,4] having index ‘1’.
     * Similarly, the next interval of [3,4] is [5,6] having index ‘2’.
     * There is no next interval for [5,6] hence we have ‘-1’.
     *
     * Example 2:
     *
     * Input: Intervals [[3,4], [1,5], [4,6]]
     * Output: [2, -1, -1]
     * Explanation: The next interval of [3,4] is [4,6] which has index ‘2’. There is no next interval for [1,5] and [4,6].
     *
     */
    public int[] findNextInterval(int[][] intervals) {
        PriorityQueue<int[]> maxStart = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> maxEnd = new PriorityQueue<>((a, b) -> b[2] - a[2]);

        int[] result = new int[intervals.length];

        for(int i = 0; i < intervals.length; i++) {
            maxStart.offer(new int[] {i, intervals[i][0], intervals[i][1]});
            maxEnd.offer(new int[] {i, intervals[i][0], intervals[i][1]});
        }

        while(!maxEnd.isEmpty()) {
            int[] topEnd = maxEnd.poll();
            result[topEnd[0]] = -1;

            if(maxStart.peek()[1] > topEnd[2]) {
                // found an entry that starts after top end
                int[] topStart = maxStart.poll();

                // let's start going backwards with starts in case there is another entry closer to topEnd
                // Imagine this scenario I have [1, 3] --> max end 3 and then I have starts [4, 6] [8, 10] [12, 16]
                // Top start will give me [12, 16] but closests is [4,6] so I keep going backwards to [4, 6]
                // Here I discard [8, 10] and [12, 16]. Why? Because I'm taking top start... meaning that
                // there are no more starts after [1, 3] therefore I useless to keep [8, 10] [12, 16] as all starts
                // before [1, 3] will also have a next interval of [4, 6]
                while(maxStart.peek()[1] > topEnd[2]) {
                    topStart = maxStart.poll();
                }

                result[topEnd[0]] = topStart[0];
                // put it back to the heap as it can be the next interval for previous starts
                maxStart.offer(topStart);
            }
        }

        return result;
    }
}
