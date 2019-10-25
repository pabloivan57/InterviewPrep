package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        // Start by adding empty subset
        subsets.add(new ArrayList<>());
        for(int currentNumber : nums) {
            // we will take existing subsets and insert in them the new number to create new subsets
            int n = subsets.size();

            for(int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }

        return subsets;
    }
}
