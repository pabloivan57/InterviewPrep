package com.pablan.grokking.patterns.topk;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KLargestNumbers {

    public List<Integer> findKLargestNumbers(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        //Put first K numbers in the heap
        for(int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // go through the remaining numbers of the array, if the number from the array is bigger than the
        // top (smallest) number of the min-heap, remove the top number from heap and add the number from array
        for (int i = k; i < nums.length; i++) {
            if(minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // the heap has the top 'K' numbers, return them in a list
        return new ArrayList<>(minHeap);
    }
}
