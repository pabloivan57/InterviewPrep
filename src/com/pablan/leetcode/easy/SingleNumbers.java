package com.pablan.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class SingleNumbers {

    /**
     * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
     *
     * Note:
     *
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * Example 1:
     *
     * Input: [2,2,1]
     * Output: 1
     * Example 2:
     *
     * Input: [4,1,2,1,2]
     * Output: 4
     *
     * Pablo's notes: Doing this with no extra space requires math. It's not expected you know this, but common
     * sense (set, hashmap, etc) is
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }

        return !set.isEmpty() ? set.iterator().next() : -1;
    }
}
