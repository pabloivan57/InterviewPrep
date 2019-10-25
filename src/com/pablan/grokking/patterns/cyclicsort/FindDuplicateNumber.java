package com.pablan.grokking.patterns.cyclicsort;

public class FindDuplicateNumber {

    public int findNumber(int[] nums) {
        int i = 0;

        while(i < nums.length) {
            if(nums[i] != i + 1) {
                if(nums[i] != nums[nums[i] - 1]) {
                    swap(i, nums[i] - 1, nums);
                } else {
                    // we have found the duplicate
                    return nums[i];
                }
            } else {
                i++;
            }

            if(nums[i] != nums[nums[i] - 1]) {
                swap(i, nums[i] - 1, nums);
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
