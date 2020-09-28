package com.pablan.grokking.patterns.cyclicsort;

public class FindDuplicateNumber {

    /**
     *  We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
     *  The array has only one duplicate but it can be repeated multiple times.
     *  Find that duplicate number without using any extra space. You are, however, allowed to modify the input array.
     *
     *  Example 1:
     *
     *  Input: [1, 4, 4, 3, 2]
     *  Output: 4
     *  Example 2:
     *
     *  Input: [2, 1, 3, 3, 5, 4]
     *  Output: 3
     *  Example 3:
     *
     *  Input: [2, 4, 1, 4, 4]
     *  Output: 4
     */
    public int findNumber(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] != nums[nums[i] - 1]){
                swap(i, nums[i] - 1,  nums);
            } else if(i != nums[i] - 1) {
                return nums[i]; // This is the duplicate
            } else {
                i++;
            }
        }

        return -1;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
    }
}
