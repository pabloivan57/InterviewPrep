package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

import java.util.List;

public class LetterCaseStringPermutationTest {

    @Test
    public void test() {
        List<String> result = new LetterCaseStringPermutation().findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = new LetterCaseStringPermutation().findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
