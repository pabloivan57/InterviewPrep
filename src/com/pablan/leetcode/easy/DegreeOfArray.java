package com.pablan.leetcode.easy;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    /**
     * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
     *
     * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
     *
     * Example 1:
     * Input: [1, 2, 2, 3, 1]
     * Output: 2
     * Explanation:
     * The input array has a degree of 2 because both elements 1 and 2 appear twice.
     * Of the subarrays that have the same degree:
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * The shortest length is 2. So return 2.
     * Example 2:
     * Input: [1,2,2,3,1,4,2]
     * Output: 6
     *
     * Pablo's notes: This is an interesting problem, the key is to keep track of the first and last appearances
     * of each number. This is because from the whole array, there must be a subarray containing the longest range
     * of the degree. In other words x[right] - x[left] + 1 is candidate when x[right] | x[left] == degree
     *
     * Basically, let's imagine a unique number is the max degree right? Obviously the shortest array
     * will be the last appereance - the first appereance. Easy enough... now what happens if you have multiple
     * numbers with the same degree? Easy enough, test all last appareance - fisrt appareance of each one of them
     * and then return the smallest.
     *
     * That means we have to
     * 1.- for each number, get the first time we see it
     * 2.- for each number, get the last time we see it
     * 3.- get the degree of each number
     * 4.- find out which one is the max degree (multiple numbers could have the same max degree)
     * 5.- For all the numbers that have 'max degree' find out the shortest between first time we saw it
     * and last time we saw it
     */
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> leftIndex = new HashMap<>();
        Map<Integer, Integer> rightIndex = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            if(!leftIndex.containsKey(num)) {
                leftIndex.put(num, i);
            }
            rightIndex.put(num, i);

            degree.put(num, degree.getOrDefault(num, 0) + 1);
        }

        int minRange = Integer.MAX_VALUE;
        int maxDegree = Collections.max(degree.values());
        for(Integer num : degree.keySet()) {
            if(degree.get(num) == maxDegree) {
                minRange = Math.min(minRange, rightIndex.get(num) - leftIndex.get(num) + 1);
            }
        }

        return minRange;
    }
}
