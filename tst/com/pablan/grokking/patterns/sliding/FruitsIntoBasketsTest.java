package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class FruitsIntoBasketsTest {

    @Test
    public void test() {
        FruitsIntoBaskets fruitsIntoBaskets = new FruitsIntoBaskets();

        System.out.println(fruitsIntoBaskets.findLength(new char[] {'A', 'B', 'C', 'A', 'C'})); // should be 3
        System.out.println(fruitsIntoBaskets.findLength(new char[] {'A', 'B', 'C', 'B', 'B', 'C'})); // should be 5
    }
}
