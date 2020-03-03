package com.pablan.leetcode.medium;

import org.junit.Test;

public class CoinChangeTest {

    @Test
    public void test() {
        CoinChange coinChange = new CoinChange();

        System.out.println(coinChange.coinChange(new int[] {1, 2, 5}, 11)); // should be 3
        System.out.println(coinChange.coinChange(new int[] {2}, 3)); // should be -1
    }
}
