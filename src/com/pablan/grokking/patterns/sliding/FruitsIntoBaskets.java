package com.pablan.grokking.patterns.sliding;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

    /**
     *  Given an array of characters where each character represents a fruit tree,
     *  you are given two baskets and your goal is to put maximum number of fruits in each basket.
     *  The only restriction is that each basket can have only one type of fruit.
     *
     *  You can start with any tree, but once you have started you can’t skip a tree.
     *  You will pick one fruit from each tree until you cannot, i.e., you will stop when you have
     *  to pick from a third fruit type.
     *
     * Input: Fruit=['A', 'B', 'C', 'A', 'C']
     * Output: 3
     * Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
     *
     */
    public int findLength(char[] arr) {
        int maxFruitCount = 0;
        int windowStart = 0;
        Map<Character, Integer> fruitCounts = new HashMap<>();

        int fruitCounter = 0;
        for(int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            Character fruit = arr[windowEnd];
            fruitCounts.put(fruit, fruitCounts.getOrDefault(fruit, 0) + 1);
            fruitCounter++;

            while(fruitCounts.size() > 2) {
                Character leavingFruit = arr[windowStart++];
                fruitCounts.put(leavingFruit, fruitCounts.get(leavingFruit) - 1);
                if(fruitCounts.get(leavingFruit) <= 0) {
                    fruitCounts.remove(leavingFruit);
                }
                fruitCounter--;
            }

            if(fruitCounter > maxFruitCount) {
                maxFruitCount = fruitCounter;
            }
        }

        return maxFruitCount;
    }
}
