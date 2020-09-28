package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

public class FindAllDuplicateNumbersTest {

    @Test
    public void test() {
        FindAllDuplicateNumbers findAllDuplicateNumbers = new FindAllDuplicateNumbers();
        System.out.println(findAllDuplicateNumbers.findNumbers(new int[] {3, 4, 4, 5, 5}));
        System.out.println(findAllDuplicateNumbers.findNumbers(new int[] {5, 4, 7, 2, 3, 5, 3}));
    }
}
