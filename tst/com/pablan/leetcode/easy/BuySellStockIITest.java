package com.pablan.leetcode.easy;

import org.junit.Test;

public class BuySellStockIITest {

    @Test
    public void test() {
        BuySellStockII buySellStock = new BuySellStockII();
        System.out.println(buySellStock.maxProfit(new int[] {7,1,5,3,6,4}));
        System.out.println(buySellStock.maxProfit(new int[] {1,2,3,4,5}));
        System.out.println(buySellStock.maxProfit(new int[] {7,6,4,3,1}));
    }
}
