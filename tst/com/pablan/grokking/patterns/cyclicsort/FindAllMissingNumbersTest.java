package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

import java.util.List;

public class FindAllMissingNumbersTest {

    @Test
    public void test() {
        FindAllMissingNumbers allMissingNumbers = new FindAllMissingNumbers();

        List<Integer> missing = allMissingNumbers.findNumbers(new int[] { 2, 3, 1, 8, 2, 3, 5, 1 });
        System.out.println("Missing numbers: " + missing);

        missing = allMissingNumbers.findNumbers(new int[] { 2, 4, 1, 2 });
        System.out.println("Missing numbers: " + missing);

        missing = allMissingNumbers.findNumbers(new int[] { 2, 3, 2, 1 });
        System.out.println("Missing numbers: " + missing);
    }
}
