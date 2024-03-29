package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.intervals.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingIntervals {

    /**
     * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
     *
     *
     *
     * Example 1:
     *
     * Input: [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
     * Example 2:
     *
     * Input: [[1,2],[1,2],[1,2]]
     * Output: 2
     * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
     *
     * Pablo's notes: Here you have to go greedy, you have to prefer the interval that has a lesser
     * chance to overlap others, in other words the smaller. For example imagine
     * [1,7],[2,3],[4,5],[6,7]
     * if you keep comparing 1 to everything you will end up with 3 removals, whereas if you remove 1 from the
     * beginning, you have only 1
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        return eraseOverlapIntervals(intervalList);
    }

    private int eraseOverlapIntervals(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()) return 0;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        int removals = 0;
        Interval interval = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);

            if(interval.end <= currentInterval.start) {
                // they don't overlap, continue
                interval = currentInterval;
                continue;
            } else {
                if(currentInterval.end < interval.end) {
                    interval = currentInterval;
                }
                removals++;
            }
        }

        return removals;
    }
}
