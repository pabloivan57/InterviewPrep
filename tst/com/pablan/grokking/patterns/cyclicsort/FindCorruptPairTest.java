package com.pablan.grokking.patterns.cyclicsort;

import org.junit.Test;

import java.util.Arrays;

public class FindCorruptPairTest {

    @Test
    public void test() {
        FindCorruptPair findCorruptPair = new FindCorruptPair();
        System.out.println(Arrays.toString(findCorruptPair.findNumbers(new int[] {3, 1, 2, 5, 2})));
        System.out.println(Arrays.toString(findCorruptPair.findNumbers(new int[] {3, 1, 2, 3, 6, 4})));
    }
}
