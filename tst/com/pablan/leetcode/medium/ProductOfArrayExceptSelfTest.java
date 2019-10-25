package com.pablan.leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void test() {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();

        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[] {1,2,3,4})));
    }
}
