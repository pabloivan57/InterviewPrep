package com.pablan.grokking.patterns.intervals;

import org.junit.Test;

public class MinimumMeetingRoomsTest {

    @Test
    public void test() {
        MinimumMeetingRooms minimumMeetingRooms = new MinimumMeetingRooms();
        System.out.println(minimumMeetingRooms.findMinimumMeetingRooms(new int[][] {{1,4}, {2,5}, {7,9}}));
        System.out.println(minimumMeetingRooms.findMinimumMeetingRooms(new int[][] {{4,5}, {2,3}, {2,4}, {3,5}}));
    }
}
