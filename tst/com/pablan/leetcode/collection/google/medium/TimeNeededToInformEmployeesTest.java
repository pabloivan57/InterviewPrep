package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class TimeNeededToInformEmployeesTest {

    @Test
    public void test() {
        TimeNeededToInformEmployees tNeeded = new TimeNeededToInformEmployees();

        System.out.println(tNeeded.numOfMinutes(1, 0, new int[] {-1}, new int[] {0})); // should be 0
        System.out.println(tNeeded.numOfMinutes(6, 2, new int[] {2,2,-1,2,2,2}, new int[] {0,0,1,0,0,0})); // should be 1
        System.out.println(tNeeded.numOfMinutes(7, 6, new int[] {1,2,3,4,5,6,-1}, new int[] {0,6,5,4,3,2,1})); // should be 21
        System.out.println(tNeeded.numOfMinutes(15, 0,
                new int[] {-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6},
                new int[] {1,1,1,1,1,1,1,0,0,0,0,0,0,0,0})); // should be 3
    }
}
