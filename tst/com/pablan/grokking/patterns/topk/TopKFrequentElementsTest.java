package com.pablan.grokking.patterns.topk;

import org.junit.Test;

import java.util.List;


public class TopKFrequentElementsTest {

    @Test
    public void test() {
        List<Integer> result = new TopKFrequentNumbers().findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);

        result = new TopKFrequentNumbers().findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
        System.out.println("Here are the K frequent numbers: " + result);
    }
}
