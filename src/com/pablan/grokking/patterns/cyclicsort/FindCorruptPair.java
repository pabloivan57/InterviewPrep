package com.pablan.grokking.patterns.cyclicsort;

public class FindCorruptPair {

    /**
     *  We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
     *  The array originally contained all the numbers from 1 to ‘n’, but due to a data error,
     *  one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.
     *
     *  Example 1:
     *
     *  Input: [3, 1, 2, 5, 2]
     *  Output: [2, 4]
     *  Explanation: '2' is duplicated and '4' is missing.
     *  Example 2:
     *
     *  Input: [3, 1, 2, 3, 6, 4]
     *  Output: [3, 5]
     *  Explanation: '3' is duplicated and '5' is missing.
     */
    public int[] findNumbers(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] - 1 <  nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
            } else {
                i++;
            }
        }

        // Now that numbers are in place, find duplicate and missing
        int duplicate = -1;
        int missing = -1;
        for(int j = 0; j < nums.length; j++) {
            if(j != nums[j] - 1) {
                if(nums[j] - 1 < nums.length && nums[j] == nums[nums[j] - 1]) {
                    duplicate = nums[j];
                }
                missing = j + 1;
            }
        }

        return new int[] {duplicate, missing};
    }

    private void swap(int i, int j, int nums[]) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }
}
