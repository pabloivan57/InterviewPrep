package com.pablan.grokking.patterns.modifiedbinary;

import org.junit.Test;

public class CeilingOfANumberTest {

    @Test
    public void test() {
        System.out.println(new CeilingOfANumber().searchCeilingOfANumber(new int[] { 4, 6, 10 }, 6));
        System.out.println(new CeilingOfANumber().searchCeilingOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
        System.out.println(new CeilingOfANumber().searchCeilingOfANumber(new int[] { 4, 6, 10 }, 17));
        System.out.println(new CeilingOfANumber().searchCeilingOfANumber(new int[] { 4, 6, 10 }, -1));
    }
}
