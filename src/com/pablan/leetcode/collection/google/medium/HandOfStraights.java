package com.pablan.leetcode.collection.google.medium;

import java.util.TreeMap;

public class HandOfStraights {

    /**
     * Alice has a hand of cards, given as an array of integers.
     *
     * Now she wants to rearrange the cards into groups so that each group is size W,
     * sand consists of W consecutive cards.
     *
     * Return true if and only if she can.
     *
     * Example 1:
     *
     * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
     * Output: true
     * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
     * Example 2:
     *
     * Input: hand = [1,2,3,4,5], W = 4
     * Output: false
     * Explanation: Alice's hand can't be rearranged into groups of 4.
     *
     * Pablo's notes: 2 things to remember
     *
     * 1.- The key is to notice that we should always start with the smallest card in our hand,
     * this work because in a straight hand the smallest will always be the start of a sequence
     *
     * 2.- There is a structure called TreeMap that keeps the keys in natural order, think of a
     * minHeap with data associated. The structure is perfect here because we want to always
     * pick the smallest but at the same time manipulate the entries. You could do
     * this with a minHeap but then it's hard to find the nodes, and you would end up using a
     * map to find the nodes + minHeap to always pick the smallest. Plus removing values with
     * just one entry from the min heap
     */
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> occurrences = new TreeMap<>();
        for(int i = 0; i < hand.length; i++) {
            occurrences.put(hand[i], occurrences.getOrDefault(hand[i], 0) + 1);
        }

        while(occurrences.size() > 0) {
            int minVal = occurrences.firstKey();
            for(int seq = minVal; seq < minVal + W; seq++) {
                // if there is not such a sequence, fail, it's impossible to have a straight
                if(!occurrences.containsKey(seq)) {
                    return false;
                }

                if(occurrences.get(seq) == 1) {
                   occurrences.remove(seq);
                } else if(occurrences.get(seq) > 1) {
                    occurrences.put(seq, occurrences.get(seq) - 1);
                }
            }
        }

        return true;
    }
}
