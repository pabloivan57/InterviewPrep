package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

public class FindSmallestPositiveMissingNumberTest {

    @Test
    public void test() {
        FindSmallestPositiveMissingNumber findSmallestPositiveMissingNumber = new FindSmallestPositiveMissingNumber();
        System.out.println(findSmallestPositiveMissingNumber.findNumber(new int[] {-3, 1, 5, 4, 2})); // Should be 3
        System.out.println(findSmallestPositiveMissingNumber.findNumber(new int[] {3, -2, 0, 1, 2})); // Should be 4
    }
}
