package com.pablan.grokking.patterns.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public String rearrangeString(String str) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : str.toCharArray()) {
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        //add all characters to the maxHeap
        for(Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
            maxHeap.offer(entry);
        }

        Map.Entry<Character, Integer> previousEntry = null;
        StringBuilder resultString = new StringBuilder(str.length());
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currentEntry = maxHeap.poll();
            // add the previous entry back in the heap if its frequency is greater than zero
            if (previousEntry != null && previousEntry.getValue() > 0)
                maxHeap.offer(previousEntry);

            // append the current character to the result string and decrement it's count
            resultString.append(currentEntry.getKey());
            currentEntry.setValue(currentEntry.getValue() - 1);
            previousEntry = currentEntry;
        }

        // if we were successful in appending all the characters to the result string, return it
        return resultString.length() == str.length() ? resultString.toString() : "";
    }
}
