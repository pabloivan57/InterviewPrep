package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

import java.util.List;

public class PermutationsTest {

    @Test
    public void test() {
        Permutations permutations = new Permutations();
        List<List<Integer>> result = permutations.permute(new int[] {1, 2, 3});
        System.out.println(result);
    }
}
