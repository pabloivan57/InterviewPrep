package com.pablan.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * Note: At first glance this looks like two pointer, but  to do so
     * you would have to sort and then it messes up with the indexes. Instead,
     * you go about this with a map where you keep track of number and index
     *
     * 2, 7, 11, 15
     *
     * 2 -> 0,
     * 7 -> 1,
     * 11 -> 2,
     * 15 -> 3
     *
     * 9 - 2 = 7, is there a key with 7?. Yes, at index 1
     * so we return 0, 1
     *
     * @param nums
     * @param target
     * @return
     */

    //Given nums = [2, 7, 11, 15], target = 9,
    //
    //Because nums[0] + nums[1] = 2 + 7 = 9,
    //return [0, 1].
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(complementMap.containsKey(complement)) {
                return new int[] {complementMap.get(complement), i};
            }

            complementMap.put(nums[i], i);
        }

        return null;
    }
}
