package com.pablan.grokking.patterns.fastslow;

import org.junit.Test;

public class CircularArrayLoopTest {

    @Test
    public void test() {
        CircularArrayLoop circularArrayLoop = new CircularArrayLoop();
        //System.out.println(circularArrayLoop.loopExists(new int[] {1, 2, -1, 2, 2})); // should be true, 0 -> 1 -> 3 -> 0
        //System.out.println(circularArrayLoop.loopExists(new int[] {2, 2, -1, 2})); // should be true, 1 -> 3 -> 1
        System.out.println(circularArrayLoop.loopExists(new int[] {2, 1, -1, -2})); // should be false, 1 -> 2 but by definition a cycle can't only have two
    }
}
