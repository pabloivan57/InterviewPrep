package com.pablan.grokking.patterns.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllDuplicateNumbers {

    /**
     * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
     * The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.
     *
     * Example 1:
     *
     * Input: [3, 4, 4, 5, 5]
     * Output: [4, 5]
     * Example 2:
     *
     * Input: [5, 4, 7, 2, 3, 5, 3]
     * Output: [3, 5]
     */
    public List<Integer> findNumbers(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] -  1, nums);
            } else {
                i++;
            }
        }

        Set<Integer> duplicates = new HashSet<>();
        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j] - 1) {
                //  this a duplicate because we already placed all numbers in their correct index
                duplicates.add(nums[j]);
            }
        }

        return new ArrayList<>(duplicates);
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
    }
}
