package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class ValidateStackSequencesTest {

    @Test
    public void test() {
        ValidateStackSequences validateStackSequences =  new ValidateStackSequences();

        System.out.println(validateStackSequences.validateStackSequences(new int[] {1,2,3,4,5},
                new int[] {4,5,3,2,1})); // Should be true
        System.out.println(validateStackSequences.validateStackSequences(new int[] {1,2,3,4,5},
                new int[] {4,3,5,1,2})); // Should be true
    }
}
