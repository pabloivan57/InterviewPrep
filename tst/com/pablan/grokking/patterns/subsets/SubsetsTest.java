package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

import java.util.List;

public class SubsetsTest {

    @Test
    public void test() {
        List<List<Integer>> result = new Subsets().findSubsets(new int[] { 1, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = new Subsets().findSubsets(new int[] { 1, 5, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
