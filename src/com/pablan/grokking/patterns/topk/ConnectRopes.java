package com.pablan.grokking.patterns.topk;

import java.util.PriorityQueue;

public class ConnectRopes {

    public int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for(int i = 0; i < ropeLengths.length; i++) {
            minHeap.offer(ropeLengths[i]);
        }

        int totalCost = 0;

        while(minHeap.size() > 1) {
            Integer rope1 = minHeap.poll();
            Integer rope2 = minHeap.poll();

            Integer connectionCost = rope1 + rope2;
            totalCost += connectionCost;
            minHeap.offer(connectionCost);
        }

        return totalCost;
    }
}
