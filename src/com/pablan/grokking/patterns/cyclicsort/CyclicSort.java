package com.pablan.grokking.patterns.cyclicsort;

public class CyclicSort {

    public void sort(int[] nums) {

        int i = 0;

        while(i < nums.length) {
            int j = nums[i] - 1;

            if(nums[i] != nums[j]) {
                swap(nums, i, j);
            } else {
                i++;
            }
        }

        return;
    }

    private void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
