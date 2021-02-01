package com.pablan.leetcode.collection.google.hard;

import java.util.Arrays;

public class Candy {

    /**
     * There are N children standing in a line. Each child is assigned a rating value.
     *
     * You are giving candies to these children subjected to the following requirements:
     *
     * Each child must have at least one candy. Children with a higher rating get more candies than their neighbors.
     * What is the minimum candies you must give?
     *
     * Pablo's notes: the way to go about this problem is a greedy approach. First you make sure you give all of them
     * at least 1 candy
     *
     * ratings:  [1,0,2]
     * candy: [1, 1, 1]
     *
     * Now... you make sure that from left to right. Every right neighbor with higher rating has more than it's left neighbor
     *
     * 0 > 1 ? nope... we don't give it more rating
     * 2 > 0 ? yes, we give it one extra rating
     *
     * ratings: [1, 0, 2]
     * candy: [1, 1, 2]
     *
     * Now... from right to left make sure the left neighbor with higher rating has already more candy? If not... add
     * as many needed to make it more?
     *
     * 0 > 2 ? Nope... don't add candy
     * 1 > 0 ? Yes.. and 1 == 1 so we have to give the left side +1 candy
     *
     * ratings: [1, 0, 2]
     * candy: [2, 1, 2]
     *
     *
     * Other example:
     * 1 3 2
     *
     * candy step 0: [1, 1, 1]
     * candy step 1: [1, 2, 1]
     * candy step 2: [1, 2, 1]
     */
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];

        // step 1: make sure all of them have candy
        Arrays.fill(candy, 1);

        // step 2: from left to right, make sure right neighbor with higher rate has more candy that left neighbor
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i + 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        // step 3: from right to left, make sure left with higher rate has at least 1 more than right neighbor
        for(int i = ratings.length - 1; i >= 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }

        // step 4: count how much candy I need
        int result = 0;
        for(int i = 0; i < candy.length; i++) {
            result += candy[i];
        }

        return result;
    }
}
