package com.pablan.grokking.patterns.topk;

import org.junit.Test;

import java.util.List;

public class KLargestNumbersTest {

    @Test
    public void test() {
        List<Integer> result = new KLargestNumbers().findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
        System.out.println("Here are the top K numbers: " + result);

        result = new KLargestNumbers().findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Here are the top K numbers: " + result);
    }
}
