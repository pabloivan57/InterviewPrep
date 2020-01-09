package com.pablan.leetcode.easy;

import org.junit.Test;

public class IntersectionofTwoArraysIITest {

    @Test
    public void test() {
        IntersectionOfTwoArraysII intersectionOfTwoArraysII = new IntersectionOfTwoArraysII();
        System.out.println(intersectionOfTwoArraysII.intersect(new int[] {1,2,2,1}, new int[] {2,2}));
        System.out.println(intersectionOfTwoArraysII.intersect(new int[] {4,9,5}, new int[] {9,4,9,8,4}));
    }
}
