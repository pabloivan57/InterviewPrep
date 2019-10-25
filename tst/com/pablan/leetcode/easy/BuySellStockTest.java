package com.pablan.leetcode.easy;

import org.junit.Test;

public class BuySellStockTest {

    @Test
    public void test() {
        BuySellStock buySellStock = new BuySellStock();
        System.out.println(buySellStock.maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(buySellStock.maxProfit(new int[] {7,6,4,3,1}));
    }
}
