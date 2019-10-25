package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

public class FindMissingNumberTest {

    @Test
    public void test() {
        FindMissingNumber findMissingNumber = new FindMissingNumber();

        System.out.println(findMissingNumber.findMissingNumber(new int[] { 4, 0, 3, 1 }));
        System.out.println(findMissingNumber.findMissingNumber(new int[] { 8, 3, 5, 2, 4, 6, 0, 1 }));
    }
}
