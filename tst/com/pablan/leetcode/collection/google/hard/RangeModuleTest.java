package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class RangeModuleTest {


    @Test
    public void test() {
        RangeModule  rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14,16);
        System.out.println(rangeModule.queryRange(10, 14)); // should be true
        System.out.println(rangeModule.queryRange(13, 15)); // should be false
        System.out.println(rangeModule.queryRange(16, 17)); // should be true
    }
}
