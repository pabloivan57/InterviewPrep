package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.intervals.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeetingsRooms {

    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     *
     * Example 1:
     *
     * Input: [[0,30],[5,10],[15,20]]
     * Output: false
     */
    public boolean canAttendMeetings(int[][] intervals) {
        List<Interval> intervalList = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            intervalList.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        return canAttendMeetings(intervalList);
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) return true;

        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval interval = intervals.get(0);
        int start = interval.start;
        int end = interval.end;

        for(int i = 1; i < intervals.size(); i++) {
            Interval currentInterval = intervals.get(i);

            if(currentInterval.start < end) {
                return false;
            } else {
                start = currentInterval.start;
                end = currentInterval.end;
            }
        }

        return true;
    }
}
