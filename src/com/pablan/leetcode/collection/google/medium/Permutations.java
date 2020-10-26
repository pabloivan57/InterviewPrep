package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

    /**
     *  Given a collection of distinct integers, return all possible permutations.
     *
     * Example:
     *
     * Input: [1,2,3]
     * Output:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     */
    public List<List<Integer>> permute(int[] nums) {
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(Collections.emptyList());
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int lastNumPermutations = permutations.size();

            for(int n = 0;  n < lastNumPermutations; n++) {
                List<Integer> lastNumPermutation = permutations.poll();

                for(int j = 0; j <= lastNumPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<>(lastNumPermutation);
                    newPermutation.add(j, nums[i]);
                    if(newPermutation.size() == nums.length) {
                        // found required size
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }

        return result;
    }
}
