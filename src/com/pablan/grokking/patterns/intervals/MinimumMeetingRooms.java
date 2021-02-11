package com.pablan.grokking.patterns.intervals;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumMeetingRooms {

    /**
     * Minimum Meeting Rooms (hard) #
     * Given a list of intervals representing the start and end time of ‘N’ meetings,
     * find the minimum number of rooms required to hold all the meetings.
     *
     * Example 1:
     *
     * Meetings: [[1,4], [2,5], [7,9]]
     * Output: 2
     * Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
     * occur in any of the two rooms later.
     * Example 2:
     *
     * Meetings: [[6,7], [2,4], [8,12]]
     * Output: 1
     * Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
     * Example 3:
     *
     * Meetings: [[1,4], [2,3], [3,6]]
     * Output:2
     * Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
     * hold all the meetings.
     *
     * Example 4:
     *
     * Meetings: [[4,5], [2,3], [2,4], [3,5]]
     * Output: 2
     * Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
     *
     * Here is a visual representation of Example 4:
     */
    public int findMinimumMeetingRooms(int[][] meetings) {
        List<Meeting> meetingsList = new ArrayList<>();
        for(int i = 0; i < meetings.length; i++) {
            meetingsList.add(new Meeting(meetings[i][0], meetings[i][1]));
        }
        return findMinimumMeetingRooms(meetingsList);
    }

    public int findMinimumMeetingRooms(List<Meeting> meetings) {
        // Sort by start time
        Collections.sort(meetings, (a, b) -> a.start - b.start);

        PriorityQueue<Meeting> currentMeetings = new PriorityQueue<>((a, b) -> a.end - b.end);

        int maxMeetings = 0;

        for(int i = 0; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);

            // check if a current meeting ended
            if(!currentMeetings.isEmpty() && currentMeetings.peek().end <= meeting.start) {
                currentMeetings.poll();
            }

            currentMeetings.offer(meeting);
            maxMeetings = Math.max(maxMeetings, currentMeetings.size());
        }

        return maxMeetings;
    }

    private class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
