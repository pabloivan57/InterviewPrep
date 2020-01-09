package com.pablan.leetcode.easy;

import org.junit.Test;

import java.util.Arrays;

public class RotateArrayTest {

    @Test
    public void test() {
        RotateArray rotateArray = new RotateArray();
        System.out.println(Arrays.toString(rotateArray.rotate(new int[] {1,2,3,4,5,6,7}, 3)));
        System.out.println(Arrays.toString(rotateArray.rotate(new int[] {-1,-100,3,99}, 2)));
    }
}
