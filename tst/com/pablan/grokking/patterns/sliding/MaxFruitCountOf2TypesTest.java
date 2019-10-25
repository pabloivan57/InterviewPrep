package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class MaxFruitCountOf2TypesTest {

    @Test
    public void test() {
        System.out.println("Maximum number of fruits: " +
                new MaxFruitCountOf2Types().findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        System.out.println("Maximum number of fruits: " +
                new MaxFruitCountOf2Types().findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
