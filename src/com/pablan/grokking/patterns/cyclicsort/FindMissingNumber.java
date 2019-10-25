package com.pablan.grokking.patterns.cyclicsort;

public class FindMissingNumber {

    public int findMissingNumber(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] < nums.length && nums[i] != nums[nums[i]]) {
                swap(i, nums[i], nums);
            } else {
                i++;
            }
        }

        for(i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
    }
}
