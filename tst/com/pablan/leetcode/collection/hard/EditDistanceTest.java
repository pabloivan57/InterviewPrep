package com.pablan.leetcode.collection.hard;

import org.junit.Test;

public class EditDistanceTest {

    @Test
    public void test() {
        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.findMinOperations("bat", "but"));
        System.out.println(editDistance.findMinOperations("abdca", "cbda"));
        System.out.println(editDistance.findMinOperations("passpot", "ppsspqrt"));
    }
}
