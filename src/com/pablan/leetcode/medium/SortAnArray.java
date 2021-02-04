package com.pablan.leetcode.medium;

import java.util.Arrays;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        //mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int middle = start + (end - start) / 2;
        mergeSort(nums, start, middle);
        mergeSort(nums,middle + 1, end);
        merge(nums, start, middle, end);
    }

    public void merge(int[] nums, int start, int middle, int end) {
       int[] left = Arrays.copyOfRange(nums, start, middle + 1);
       int[] right = Arrays.copyOfRange(nums, middle + 1, end + 1);

       int p1 = 0;
       int p2 = 0;

       int current = 0;
       while(p1 < left.length && p2 < right.length) {
           if(left[p1] < left[p2]) {
               nums[current] = left[p1];
               p1++;
           } else {
               nums[current] = right[p2];
               p2++;
           }
           current++;
       }

        while(p1 < left.length) {
            nums[current] = left[p1];
            current++;
            p1++;
        }

        while(p2 < right.length) {
            nums[current] = right[p2];
            current++;
            p2++;
        }
    }

    public void quickSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }

        int pivot = partition(nums, start, end);
        quickSort(nums, 0, pivot);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = start + ((end - start) / 2);

        // swap pivot to the end and use it compare
        swap(nums, pivot, end);
        pivot = start;
        for(int j = start; j < end; j++) {
            if(nums[j] <= nums[end]) {
                swap(nums, pivot, j);
                pivot++;
            }
        }

        // at this point pivot is the right location for end
        swap(nums, pivot, end);
        return pivot;
    }

    private void swap(int[] nums, int a, int b) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }
}
