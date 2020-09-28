package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class FindMissingPositiveTest {

    @Test
    public void test() {
        FindMissingPositive findMissingPositive = new FindMissingPositive();
        System.out.println(findMissingPositive.firstMissingPositive(new int[] {1,2,0})); // should be 3
        System.out.println(findMissingPositive.firstMissingPositive(new int[] {3,4,-1,1})); // should be 2
        System.out.println(findMissingPositive.firstMissingPositive(new int[] {7,8,9,11,12})); // should be 1
    }
}
