package com.pablan.grokking.patterns.twoheaps;

import org.junit.Test;

public class MaximizeCapitalTest {

    @Test
    public void test() {
        MaximizeCapital maximizeCapital = new MaximizeCapital();
        System.out.println(maximizeCapital.findMaximumCapital(new int[] {0, 1, 2}, new int[] {1, 2, 3}, 2, 1)); // should be 6
        System.out.println(maximizeCapital.findMaximumCapital(new int[] {0,1,2,3}, new int[] {1,2,3,5}, 3, 0)); // should be 8
    }
}
