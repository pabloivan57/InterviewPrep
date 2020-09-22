package com.pablan.grokking.patterns.cyclicsort;

public class FindMissingNumber {

    /**
     *  We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
     *  Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
     *
     *  Example 1:
     *
     *  Input: [4, 0, 3, 1]
     *  Output: 2
     *  Example 2:
     *
     *  Input: [8, 3, 5, 2, 4, 6, 0, 1]
     *  Output: 7
     *
     */
    public int findMissingNumber(int[] nums) {
        int i = 0;

        while(i < nums.length)  {
            if(nums[i] < nums.length && nums[i] != nums[nums[i]])  {
                swap(i, nums[i], nums);
            } else {
                i++;
            }
        }

        int result = 0;
        for(int j = 0; j < nums.length; j++) {
            // find the very first number that is not in it's index
            if(j != nums[j]) {
                result = j;
                break;
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
