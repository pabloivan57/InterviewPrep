package com.pablan.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {

    /**
     * Given two arrays, write a function to compute their intersection.
     *
     * Example 1:
     *
     * Input: nums1 = [1,2,2,1], nums2 = [2,2]
     * Output: [2,2]
     * Example 2:
     *
     * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * Output: [4,9]
     * Note:
     *
     * Each element in the result should appear as many times as it shows in both arrays.
     * The result can be in any order.
     * Follow up:
     *
     * What if the given array is already sorted? How would you optimize your algorithm?
     * What if nums1's size is small compared to nums2's size? Which algorithm is better?
     * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
     *
     * Pablo's notes: Common sense should take you through the right path (count occurences and then get the ones that have multiple)
     * However, the optimization is cool, you use the smaller array as the buffer for intersections. For example:
     * [1, 2, 2, 1] [2, 2]
     * We start with smaller one [2, 2]
     * Map looks like
     * 2 -> 2
     * now we go to [1, 2, 2, 1], 1 is not in the map so we assume 0
     * Map looks like
     * 2 -> 2   (it's more than 0 so then this is an intersection) -> and we copy this intersection to short [x, x]
     * which know becomes [2, x] and also we reduce one count
     * Map looks like
     * 2 -> 1
     * 2 -> 1 / (it's more than 0 so we copy to array) [2, x] -> 2,2
     * Map looks like
     * 2 -> 0
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
