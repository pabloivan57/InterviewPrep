package com.pablan.grokking.patterns.cyclicsort;

import java.util.ArrayList;
import java.util.List;

public class FindAllMissingNumbers {

    /**
     * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
     * The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
     *
     * Example 1:
     *
     * Input: [2, 3, 1, 8, 2, 3, 5, 1]
     * Output: 4, 6, 7
     * Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
     * Example 2:
     *
     * Input: [2, 4, 1, 2]
     * Output: 3
     * Example 3:
     *
     * Input: [2, 3, 2, 1]
     * Output: 4
     *
     */
    public List<Integer> findNumbers(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            } else {
                i++;
            }
        }

        //  find out  all numbers there are that do  not belong  in  the position
        List<Integer> result = new ArrayList<>();
        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j] - 1) {
                result.add(j + 1);
            }
        }

        return result;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
    }
}
