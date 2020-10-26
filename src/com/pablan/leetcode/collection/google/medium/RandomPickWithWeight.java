package com.pablan.leetcode.collection.google.medium;

import java.util.Random;

public class RandomPickWithWeight {

    /**
     *  You are given an array of positive integers w where w[i] describes the weight of ith index (0-indexed).
     *
     * We need to call the function pickIndex() which randomly returns an integer in the range [0, w.length - 1].
     * pickIndex() should return the integer proportional to its weight in the w array. For example,
     * for w = [1, 3], the probability of picking the index 0 is 1 / (1 + 3) = 0.25 (i.e 25%)
     * while the probability of picking the index 1 is 3 / (1 + 3) = 0.75 (i.e 75%).
     *
     * More formally, the probability of picking index i is w[i] / sum(w).
     *
     * Pablo's notes: Straight out of the box you find out that. What this guy is telling you is that
     * each number is a distribution, or how many times the element repeats on an imaginary array of length sum.
     *
     * For example:
     *
     * [1,3] == [1, 3, 3, 3]. Now it's just a matter of picking up a random index and returning the value. Or you
     * could do as well (since it asks for indexes) [1, 3] = [0, 1, 1, 1] and that would give you the result.
     * However, in this case space = O(sum[w[i]]) because you store sum elements. But picking up a value would be O(1)
     *
     * But there is a clever way of achieving O(n) space and O(log(n)) search. When you sum up
     * all the values you get a virtual representation of where an index switches value. Let me explain
     *
     * Instead of [0, 1, 1, 1, 2, 2, 3, 3, 3]. You could have indexed the places where it changes
     * [0, 1, 4, 6]. and then Pick a random number from the total... let's say give me index 5
     * and you start binary where that index would fall in the "flag" array
     *
     * - From the flag array
     * - let's try index middle = 1
     * - Is 1 < 5, ok let's try right, low = 1
     * - middle now is 2
     * - Is 4 < 5, ok let's try right, low = 3
     * - low == high, return 3
     */

    Random random;
    int[] weights;
    int total;

    public RandomPickWithWeight(int[] w) {
        random = new Random();
        weights = new int[w.length];

        for(int i = 0; i < w.length; i++) {
            if(i == 0) {
                weights[i] = w[i];
            } else {
                weights[i] = w[i] + weights[i - 1];
            }

            total += w[i];
        }
    }

    public int pickIndex() {
        int low = 0;
        int high = weights.length;

        int target = random.nextInt(total + 1); // include end of total
        while(low < high) {
            int middle = low + ((high - low) / 2);
            if(weights[middle] == target) {
                return middle;
            }
            if(weights[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }

        return low;
    }
}
