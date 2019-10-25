package com.pablan.grokking.patterns.topk;

import org.junit.Test;

public class ConnectRopesTest {

    @Test
    public void test() {
        int result = new ConnectRopes().minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
        System.out.println("Minimum cost to connect ropes: " + result);
        result = new ConnectRopes().minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
        System.out.println("Minimum cost to connect ropes: " + result);
    }
}
