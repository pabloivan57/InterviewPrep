package com.pablan.grokking.patterns.intervals;

import org.junit.Test;

public class MaxCPULoadTest {

    @Test
    public void test() {
        MaxCPULoad maxCPULoad = new MaxCPULoad();
        System.out.println(maxCPULoad.findMaxCPULoad(new int[][] {{1,4,3}, {2,5,4}, {7,9,6}}));
    }
}
