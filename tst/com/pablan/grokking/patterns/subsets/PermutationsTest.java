package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

import java.util.List;

public class PermutationsTest {

    @Test
    public void test() {
        List<List<Integer>> result = new Permutations().findPermutationsRecursive(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
