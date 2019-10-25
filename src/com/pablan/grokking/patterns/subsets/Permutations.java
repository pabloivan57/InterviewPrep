package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutations {

    public List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for(int currentNumber : nums) {
            // we will take all existing permutations and add the current number to create new permutations
            int n = permutations.size();
            for(int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                for(int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if(newPermutation.size() == nums.length)
                        result.add(newPermutation);
                    else
                        permutations.add(newPermutation);
                }
            }
        }

        return result;
    }

    public List<List<Integer>> findPermutationsRecursive(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        findPermutationsRecursive(nums, 0, new ArrayList<>(), results);
        return results;
    }

    public void findPermutationsRecursive(int[] nums, int currentIndex, List<Integer> currentPermutation, List<List<Integer>> results) {
        if(currentPermutation.size() == nums.length) {
            results.add(currentPermutation);
            return;
        }

        if(currentIndex >= nums.length) {
            return;
        }

        for(int i = 0; i <= currentPermutation.size(); i++) {
            List<Integer> newPermutation = new ArrayList<>(currentPermutation);
            newPermutation.add(i, nums[currentIndex]);
            findPermutationsRecursive(nums, currentIndex + 1, newPermutation, results);
        }
    }
}
