package com.pablan.grokking.patterns.topk;

import org.junit.Test;

public class SumOfElementsTest {

    @Test
    public void test() {
        int result = new SumOfElements().findSumOfElements(new int[] { 1, 3, 12, 5, 15, 11 }, 3, 6);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);

        result = new SumOfElements().findSumOfElements(new int[] { 3, 5, 8, 7 }, 1, 4);
        System.out.println("Sum of all numbers between k1 and k2 smallest numbers: " + result);
    }
}
