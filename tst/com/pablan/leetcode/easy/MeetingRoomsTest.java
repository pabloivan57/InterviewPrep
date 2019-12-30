package com.pablan.leetcode.easy;

import org.junit.Test;

public class MeetingRoomsTest {

    @Test
    public void test() {
        MeetingsRooms meetingsRooms = new MeetingsRooms();
        System.out.println(meetingsRooms.canAttendMeetings(new int[][] {{0, 30}, {5, 10}, {15, 20}}));
    }
}
