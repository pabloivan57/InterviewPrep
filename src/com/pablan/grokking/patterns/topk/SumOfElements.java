package com.pablan.grokking.patterns.topk;

import java.util.PriorityQueue;

public class SumOfElements {

    public int findSumOfElements(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        //insert all numbers in the minHeap
        for(int i = 0; i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        // remove k1 small numbers from hte heap
        for(int i = 0; i < k1; i++) {
            minHeap.poll();
        }

        int elemSum = 0;

        // Sum next k2-1 numbers
        for(int i = k1; i < k2 - 1; i++) {
            elemSum += minHeap.poll();
        }

        return elemSum;
    }

    public int findSumOfElementsTopK(int[] nums, int k1, int k2) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // keep smallest k2 numbers in the maxHeap
        for(int i = 0 ; i < nums.length; i++) {
            if (i < k2 - 1) {
                maxHeap.add(nums[i]);
            } else if(nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        // get the sum of numbers between k1 and k2 indices
        // these numbers will be at the top of the max heap
        int elementSum = 0;
        for (int i = 0; i < k2 - k1 - 1; i++)
            elementSum += maxHeap.poll();

        return elementSum;
    }
}
