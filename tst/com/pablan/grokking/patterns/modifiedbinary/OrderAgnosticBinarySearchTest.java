package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class OrderAgnosticBinarySearchTest {

    @Test
    public void test() {
        System.out.println(new OrderAgnosticBinarySearch().search(new int[] { 4, 6, 10 }, 10));
        System.out.println(new OrderAgnosticBinarySearch().search(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 5));
        System.out.println(new OrderAgnosticBinarySearch().search(new int[] { 10, 6, 4 }, 10));
        System.out.println(new OrderAgnosticBinarySearch().search(new int[] { 10, 6, 4 }, 4));
    }
}
