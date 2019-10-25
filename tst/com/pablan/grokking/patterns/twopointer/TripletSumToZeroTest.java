package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

import java.util.List;

public class TripletSumToZeroTest {

    @Test
    public void test() {
        TripletSumToZero tripletSumToZero = new TripletSumToZero();
        List<List<Integer>> result = tripletSumToZero.test(new int[] {-3, 0, 1, 2, -1, 1, -2});
        System.out.println(result);
    }
}
