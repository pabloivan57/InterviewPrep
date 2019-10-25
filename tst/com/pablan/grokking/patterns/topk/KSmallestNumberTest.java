package com.pablan.grokking.patterns.topk;

import org.junit.Test;

public class KSmallestNumberTest {

    @Test
    public void test() {
        int result = new KSmallestNumber().findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = new KSmallestNumber().findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = new KSmallestNumber().findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
