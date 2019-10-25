package com.pablan.grokking.patterns.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {

        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() < 2) {
                return intervals;
            }

            // Sort intervals by start time
            Collections.sort(intervals, (a, b) -> a.start - b.start);

            List<Interval> mergedIntervals = new ArrayList<>();
            Interval interval = intervals.get(0);
            int start = interval.start;
            int end = interval.end;

            for(int i = 1; i < intervals.size(); i++) {
                interval = intervals.get(i);

                // overlapping intervals
                if(interval.start < end) {
                    // to merge we only car about end
                    end = Math.max(end, interval.end);
                } else {
                    // they don't overlap just add to the list
                    mergedIntervals.add(new Interval(start, end));
                    start = interval.start;
                    end = interval.end;
                }
            }

            // Add the last interval
            mergedIntervals.add(new Interval(start, end));

            return mergedIntervals;
        }
}
