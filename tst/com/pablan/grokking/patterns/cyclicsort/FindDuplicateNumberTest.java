package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

public class FindDuplicateNumberTest {

    @Test
    public void test() {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();

        System.out.println(findDuplicateNumber.findNumber(new int[] { 1, 4, 4, 3, 2 }));
        System.out.println(findDuplicateNumber.findNumber(new int[] { 2, 1, 3, 3, 5, 4 }));
        System.out.println(findDuplicateNumber.findNumber(new int[] { 2, 4, 1, 4, 4 }));
    }
}
