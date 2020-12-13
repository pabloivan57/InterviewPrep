package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

public class StringPermutationChangingCaseTest {

    @Test
    public void test() {
        StringPermutationChangingCase stringPermutationChangingCase = new StringPermutationChangingCase();
        System.out.println(stringPermutationChangingCase.findLetterCaseStringPermutations("ad52")); // should be ad52, Ad52, aD52, AD52
    }
}
