package com.pablan.leetcode.medium;

import org.junit.Test;

public class CourseScheduleTest {

    @Test
    public void test() {
        CourseSchedule courseSchedule = new CourseSchedule();

        System.out.println(courseSchedule.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
    }
}
