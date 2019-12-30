package com.pablan.leetcode.medium;

import org.junit.Test;

public class MeetingRoomsIITest {

    @Test
    public void test() {

        MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
        System.out.println(meetingRoomsII.minMeetingRooms(new int[][] {{7,10}, {2,4}}));
        System.out.println(meetingRoomsII.minMeetingRooms(new int[][] {{0, 30}, {5, 10}, {15, 20}}));
    }
}
