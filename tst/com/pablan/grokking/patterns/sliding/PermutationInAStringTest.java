package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class PermutationInAStringTest {

    @Test
    public void test() {
        PermutationInAString permutationInAString = new PermutationInAString();
        System.out.println(permutationInAString.findPermutation("oidbcaf", "abc")); // should be true
        System.out.println(permutationInAString.findPermutation("odicf", "dc")); // should be false
        System.out.println(permutationInAString.findPermutation("bcdxabcdy", "bcdyabcdx")); // should be true
        System.out.println(permutationInAString.findPermutation("aaacb", "abc")); // should be true
    }
}
