package com.pablan.leetcode.leetcode75;

import org.junit.jupiter.api.Test;

public class MergeStringAlternatelyTest {

    @Test
    public void test() {
        MergeStringsAlternately mergeStringsAlternately = new MergeStringsAlternately();
        final String result = mergeStringsAlternately.mergeAlternately("abc", "pqr");
        System.out.println(result); // should be apbqcr
    }
}
