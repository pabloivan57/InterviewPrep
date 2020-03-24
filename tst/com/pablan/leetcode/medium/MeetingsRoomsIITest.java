package com.pablan.leetcode.medium;

import org.junit.Test;

public class MeetingsRoomsIITest {

    @Test
    public void test() {
        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.minMeetingRooms(new int[][] {{0, 30}, {5, 10}, {15, 20}})); // should be 2
        System.out.println(meetingRoomsII.minMeetingRooms(new int[][] {{7,10}, {2,4}})); // should be 1
    }
}
