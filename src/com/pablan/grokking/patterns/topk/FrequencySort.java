package com.pablan.grokking.patterns.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public String sortCharacterByFrequency(String str) {
        Map<Character, Integer> frequencies = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for(int i = 0; i < str.length() - 1; i++) {
            Character character = str.charAt(i);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }

        // Create maxHeap
        for(Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            maxHeap.offer(entry);
        }

        // Build String
        StringBuilder builder = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for(int i = 0; i < entry.getValue(); i++) {
                builder.append(entry.getKey());
            }
        }

        return builder.toString();
    }
}
