package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class PowerFunctionDoubleTest {

    @Test
    public void test() {
        PowerFunctionDouble powerFunctionDouble = new PowerFunctionDouble();
        System.out.println(powerFunctionDouble.myPow(2.00000, 10)); // should be 1024.000
        System.out.println(powerFunctionDouble.myPow(2.10000, 3)); // should be 9.26100
        System.out.println(powerFunctionDouble.myPow(2.00000, -2)); // should be 0.25000
    }
}
