package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    //Given array nums = [-1, 0, 1, 2, -1, -4],
    //
    //A solution set is:
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //]
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            findTriplet(i + 1, -nums[i], nums, result);
        }

        return result;
    }

    private void findTriplet(int start, int target, int[] nums, List<List<Integer>> triplets) {
        int p1 = start;
        int p2 = nums.length - 1;

        while(p1 < p2) {
            if(nums[p1] + nums[p2] == target) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[p1]);
                result.add(nums[p2]);
                result.add(-target);

                triplets.add(result);
                p1++;
            } else if(nums[p1] + nums[p2] > target) {
                p2--;
            } else {
                p1++;
            }
        }
    }
}
