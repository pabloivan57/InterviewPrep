package com.pablan.grokking.patterns.topk;

import java.util.*;

public class TopKFrequentNumbers {

    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> frequencies = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            frequencies.put(nums[i], frequencies.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // create a list of top k numbers
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        return result;
    }
}
