package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.intervals.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NonOverlappingIntervals {

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
