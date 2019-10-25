package com.pablan.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {

    public List<List<Integer>> findSubsets(int[] nums) {
        // sort the numbers to handle duplicates
        Arrays.sort(nums);

        List<List<Integer>> subsets = new ArrayList<>();
        //Add the empty set
        subsets.add(new ArrayList<>());
        int startIndex = 0, endIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            startIndex = 0;

            // i > 0 just skips the first element, there cannot be a duplicate in pos 0
            if(i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = subsets.size() - 1;
            for(int j = startIndex; j <= endIndex; j++) {
                List<Integer> set = new ArrayList<>(subsets.get(j));
                set.add(nums[i]);
                subsets.add(set);
            }
        }

        return subsets;
    }
}
