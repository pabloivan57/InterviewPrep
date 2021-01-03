package com.pablan.grokking.patterns.topk;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    /**
     *  Given a string, find if its letters can be rearranged in
     *  such a way that no two same characters come next to each other.
     *
     *  Example 1:
     *
     *  Input: "aappp"
     *  Output: "papap"
     *  Explanation: In "papap", none of the repeating characters come next to each other.
     *  Example 2:
     *
     *  Input: "Programming"
     *  Output: "rgmrgmPiano" or "gmringmrPoa" or "gmrPagimnor", etc.
     *  Explanation: None of the repeating characters come next to each other.
     *  Example 3:
     *
     *  Input: "aapa"
     *  Output: ""
     *  Explanation: In all arrangements of "aapa", atleast two 'a' will come together e.g., "apaa", "paaa".
     *
     */
    public String rearrangeString(String str) {
        Map<Character, Integer> occurrences = new HashMap<>();
        char[] letters = str.toCharArray();

        // occurences
        for(int i = 0; i < letters.length; i++) {
            occurrences.put(letters[i], occurrences.getOrDefault(letters[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            maxHeap.offer(entry);
        }

        StringBuilder result = new StringBuilder();
        Map.Entry<Character, Integer> previousEntry = null;
        while(!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            result.append(current.getKey());
            current.setValue(current.getValue() - 1);
            // put in back on the maxHeap
            if(previousEntry != null && previousEntry.getValue() > 0) {
                maxHeap.offer(previousEntry);
            }
            // set current to previous entry
            previousEntry = current;
        }

        // if previous entry has a value here that means there a few letter left to process
        while(previousEntry != null && previousEntry.getValue() > 0) {
            result.append(previousEntry.getKey());
            previousEntry.setValue(previousEntry.getValue() - 1);
        }

        return result.toString();
    }
}
