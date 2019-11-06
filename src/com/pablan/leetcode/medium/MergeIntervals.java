package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

    private class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Example 1:
     *
     * Input: [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
     */
    public int[][] merge(int[][] intervals) {
        List<Interval> intervalsList = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            intervalsList.add(new Interval(interval[0], interval[1]));
        }

        List<Interval> mergedIntervals = merge(intervalsList);

        int[][] result = new int[mergedIntervals.size()][2];
        for(int i = 0; i < mergedIntervals.size(); i++) {
            Interval interval = mergedIntervals.get(i);
            result[i][0] = interval.start;
            result[i][1] = interval.end;
        }

        return result;
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return Collections.emptyList();

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();
        Interval interval = intervals.get(0);
        int start = interval.start;
        int end = interval.end;

        for(int i = 1; i < intervals.size(); i++) {
            Interval currentInterval =  intervals.get(i);
            if(currentInterval.start  <= end) {
                // They overlap, we have to make it a single interval
                end = Math.max(end, currentInterval.end);
            } else {
                // tracking interval doesn't overlap, add it to the list
                result.add(new Interval(start, end));
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }

        // we need to add tracking interval at the end
        result.add(new Interval(start, end));

        return result;
    }
}
