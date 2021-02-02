package com.pablan.leetcode.easy;

import org.junit.Test;

public class MinStackTest {

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(6);
        minStack.push(2);

        System.out.println(minStack.pop()); // should be 2
    }
}
