package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
     *
     * Example 1:
     *
     * Input: [[0, 30],[5, 10],[15, 20]]
     * Output: 2
     * Example 2:
     *
     * Input: [[7,10],[2,4]]
     * Output: 1
     *
     * Pablo's notes: The trick here is that you need to order them by two dimensions, first start time and then end time
     * a heap fits perfectly. You keep adding start times in order and then pop end times in order too. At any point in
     * time the heap will give you how many rooms are required
     */
    public int minMeetingRooms(int[][] intervals) {
        List<Interval> intervalsList = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            intervalsList.add(new Interval(interval[0], interval[1]));
        }

        return minMeetingRooms(intervalsList);
    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Ascending by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // keep the min end time of the rooms
        int minMeetingRooms = 0;
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        minHeap.add(intervals.get(0));

        for(int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(minHeap.peek().end < interval.start) {
                minHeap.poll();
            }

            minHeap.offer(interval);

            minMeetingRooms = Math.max(minMeetingRooms, minHeap.size());
        }

        return minMeetingRooms;
    }

    private class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
