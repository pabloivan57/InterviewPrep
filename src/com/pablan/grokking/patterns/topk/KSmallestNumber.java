package com.pablan.grokking.patterns.topk;

import java.util.PriorityQueue;

public class KSmallestNumber {

    public int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int i = 0; i < k; i++) {
            maxHeap.offer(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(maxHeap.peek() > nums[i]) {
                maxHeap.poll();
                maxHeap.offer(nums[i]);
            }
        }

        return maxHeap.peek();
    }
}
