package com.pablan.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> ocurrences = new HashSet<>();

        for(int i =  0; i < nums.length; i++) {
            if(ocurrences.contains(nums[i])) {
                return true;
            }
            ocurrences.add(nums[i]);
        }

        return false;
    }
}
