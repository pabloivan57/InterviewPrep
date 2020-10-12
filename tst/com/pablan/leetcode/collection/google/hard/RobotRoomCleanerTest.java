package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class RobotRoomCleanerTest {

    @Test
    public void test() {
        int[][] room = new int[][] {
                {1,1,1,1,1,0,1,1},
                {1,1,1,1,1,0,1,1},
                {1,0,1,1,1,1,1,1},
                {0,0,0,1,0,0,0,0},
                {1,1,1,1,1,1,1,1}
        };

        RobotRoomCleaner robotRoomCleaner = new RobotRoomCleaner(1, 3, room);


    }
}
