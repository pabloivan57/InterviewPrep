package com.pablan.leetcode.hard;

import com.pablan.grokking.patterns.intervals.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    /**
     * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
     *
     * You may assume that the intervals were initially sorted according to their start times.
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
     * Output: [[1,5],[6,9]]
     *
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<Interval> intervalList = toIntervalList(intervals);
        Interval newIntervalObject = toInterval(newInterval);

        List<Interval> result = insert(intervalList, newIntervalObject);
        int[][] resultIntervalArray = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            resultIntervalArray[i][0] = result.get(i).start;
            resultIntervalArray[i][1] = result.get(i).end;
        }

        return resultIntervalArray;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();
        Interval intervalToCompare = newInterval;

        for(Interval interval : intervals) {
            if(interval.end < intervalToCompare.start) {
                // Doesn't overlap, add to result
                result.add(interval);
            } else if(intervalToCompare.end < interval.start) {
                // Also do not overlap, current interval comes after intervalToCompare, add intervalToCompare to result
                result.add(new Interval(intervalToCompare.start, intervalToCompare.end));
                intervalToCompare.start = interval.start;
                intervalToCompare.end = interval.end;
            } else {
                intervalToCompare.start = Math.min(interval.start, intervalToCompare.start);
                intervalToCompare.end = Math.max(interval.end, intervalToCompare.end);
            }
        }

        result.add(intervalToCompare);

        return result;
    }

    private Interval toInterval(int[] interval) {
        Interval newInterval = new Interval(interval[0], interval[1]);
        return newInterval;
    }

    private List<Interval> toIntervalList(int[][] intervals) {
        List<Interval> result = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            Interval newInterval = toInterval(interval);
            result.add(newInterval);
        }

        return result;
    }
}
