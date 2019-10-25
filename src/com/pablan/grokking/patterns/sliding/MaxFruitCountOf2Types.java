package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

    //Input: Fruit=['A', 'B', 'C', 'A', 'C']
    //Output: 3
    //Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
    public int findLength(char[] arr) {
        Map<Character, Integer> occurrences = new HashMap<>();
        int windowStart = 0;
        int maxFruits = 0;

        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            occurrences.put(arr[windowEnd], occurrences.getOrDefault(arr[windowEnd], 0) + 1);

            while(occurrences.size() > 2) {
                // Remove window start as is leaving the sliding window
                occurrences.put(arr[windowStart], occurrences.get(arr[windowStart]) - 1);
                // If 0 remove from the occurrences list
                if(occurrences.get(arr[windowStart]) == 0) {
                    occurrences.remove(arr[windowStart]);
                }
                // move the window
                windowStart++;
            }

            // Max amount of fruits
            int fruitSum = 0;
            for(int fruitCount : occurrences.values()) {
                fruitSum += fruitCount;
            }
            maxFruits = Math.max(maxFruits, fruitSum);
        }

        return maxFruits;
    }
}
