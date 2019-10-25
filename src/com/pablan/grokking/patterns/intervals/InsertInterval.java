package com.pablan.grokking.patterns.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InsertInterval {

    //Input: Intervals=[[1,3], [5,7], [8,12]], New Interval=[4,6]
    //Output: [[1,3], [4,7], [8,12]]
    //Explanation: After insertion, since [4,6] overlaps with [5,7], we merged them into one [4,7]
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals.isEmpty()) {
            return Arrays.asList(newInterval);
        }

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        List<Interval> result = new ArrayList<>();
        Interval interval = newInterval;
        int start = interval.start;
        int end = interval.end;

        for(int i = 0; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);
            if(currentInterval.start > end) {
                // new interval comes after current interval
                result.add(new Interval(start, end));
                start = currentInterval.start;
                end = currentInterval.end;
            } else if(currentInterval.end < start) {
                // current interval comes before the new interval
                result.add(currentInterval);
            }  else {
                // new interval overlaps with current interval
                end = Math.max(end, currentInterval.end);
            }
        }

        // Add the last interval that was merged
        result.add(new Interval(start, end));

        return result;
    }

    public List<Interval> insertFancy(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        List<Interval> result = new ArrayList<>();

        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            result.add(intervals.get(i++));
        }

        int start = newInterval.start;
        int end = newInterval.end;
        while(intervals.get(i).start < newInterval.end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }

        result.add(new Interval(start, end));

        while(i < intervals.size()) {
            result.add(intervals.get(i++));
        }

        return result;
    }
}
