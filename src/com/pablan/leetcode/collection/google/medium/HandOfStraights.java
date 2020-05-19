package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     */
    public boolean isNStraightHand(int[] hand, int W) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        Map<Integer, List<SequenceData>> openSequences = new HashMap<>();

        for(int i = 0; i < hand.length; i++) {
            occurrences.put(hand[i], occurrences.getOrDefault(hand[i], 0) + 1);
        }

        for(int i = 0; i < hand.length; i++) {
            int number = hand[i];
            if(occurrences.get(number) == 0) {
                continue;
            }

            List<SequenceData> sequencePossibilities = openSequences.get(number);
            // append use case
            if(sequencePossibilities != null && !sequencePossibilities.isEmpty()) {
                SequenceData seq = sequencePossibilities.get(0);
                // If we will reach the desired length for a sequence, just close it
                if(seq.seqLength + 1 == W) {
                    openSequences.remove(seq.seqLength);
                } else {
                    // try to extend sequence
                    sequencePossibilities.remove(seq);

                    SequenceData newSeq = new SequenceData(seq.value + 1, seq.seqLength + 1);
                    List<SequenceData> newSeqPossibilities =  openSequences.getOrDefault(newSeq.value, new ArrayList<>());
                    newSeqPossibilities.add(newSeq);
                    openSequences.put(newSeq.value, newSeqPossibilities);
                }
            } else if(occurrences.get(number) > 0) {
                // Create new sequence use case
                SequenceData newSeq = new SequenceData(number + 1, 1);
                List<SequenceData> newSeqPossibilities = openSequences.getOrDefault(newSeq.value, new ArrayList<>());
                newSeqPossibilities.add(newSeq);
                openSequences.put(newSeq.value, newSeqPossibilities);
            } else {
                return false;
            }
        }

        return openSequences.isEmpty();
    }

    private static class SequenceData {
        int value;
        int seqLength;

        public SequenceData(int value, int seqLength) {
            this.value = value;
            this.seqLength = seqLength;
        }
    }
}
