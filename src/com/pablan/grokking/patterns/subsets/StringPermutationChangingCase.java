package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringPermutationChangingCase {

    /**
     *  Given a string, find all of its permutations preserving the character sequence but changing case.
     *
     *  Example 1:
     *
     *  Input: "ad52"
     *  Output: "ad52", "Ad52", "aD52", "AD52"
     */
    public List<String> findLetterCaseStringPermutations(String str) {
        List<String> result = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        queue.add("");

        for(int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            int levelSize = queue.size();

            for(int j = 0; j < levelSize; j++) {
                String current = queue.poll();
                if(Character.isLetter(letter)) {
                    queue.offer(current + Character.toUpperCase(letter));
                    queue.offer(current + Character.toLowerCase(letter));
                } else {
                    queue.offer(current + letter);
                }
            }
        }

        // return results
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }

        return result;
    }
}
