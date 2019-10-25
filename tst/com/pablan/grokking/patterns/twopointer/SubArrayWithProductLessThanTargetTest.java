package com.pablan.grokking.patterns.twopointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SubArrayWithProductLessThanTargetTest {

    @Test
    public void test() {
        SubArrayWithProductLessThanTarget subArrayWithProductLessThanTarget = new SubArrayWithProductLessThanTarget();
        List<List<Integer>> result = subArrayWithProductLessThanTarget.solve(new int[] {2, 5, 3, 10}, 30);

        result.forEach(r -> System.out.println(Arrays.toString(r.toArray())));
    }
}
