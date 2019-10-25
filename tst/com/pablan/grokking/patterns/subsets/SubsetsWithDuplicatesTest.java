package com.pablan.grokking.patterns.subsets;

import org.junit.Test;

import java.util.List;

public class SubsetsWithDuplicatesTest {

    @Test
    public void test() {
        List<List<Integer>> result = new SubsetsWithDuplicates().findSubsets(new int[] { 1, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);

        result = new SubsetsWithDuplicates().findSubsets(new int[] { 1, 5, 3, 3 });
        System.out.println("Here is the list of subsets: " + result);
    }
}
