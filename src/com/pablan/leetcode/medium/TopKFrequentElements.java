package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     *
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();

        // count frequencies
        for(int i = 0; i < nums.length; i++) {
            occurrences.put(nums[i], occurrences.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        Collection<Map.Entry<Integer, Integer>> occurrencesEntries = occurrences.entrySet();

        for(Map.Entry<Integer, Integer> entry : occurrencesEntries) {
            minHeap.offer(entry);

            // Keep removing min frequencies until we only have k or less in the minHeap
            while(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // transform k elements in minHeap to list
        List<Integer> result = new ArrayList<>();
        while(!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }

        return result;
    }
}
