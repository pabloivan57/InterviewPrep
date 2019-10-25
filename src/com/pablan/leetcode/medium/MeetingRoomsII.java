package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRoomsII {
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
