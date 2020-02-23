package com.pablan.leetcode.theory;

import java.util.Arrays;

public class MergeSort {

    public int[] sort(int[] numbers) {
        mergeSort(0, numbers.length - 1, numbers);
        return numbers;
    }

    private void mergeSort(int start, int end, int[] numbers) {
        if(start >= end) {
            return;
        }

        int middle = start + ((end - start) / 2 );
        mergeSort(start, middle, numbers);
        mergeSort(middle + 1, end, numbers);

        merge(start, middle, end, numbers);

    }

    private void merge(int start, int middle, int end, int[] numbers) {
        int[] left = Arrays.copyOfRange(numbers, start, middle + 1);
        int[] right = Arrays.copyOfRange(numbers, middle + 1, end + 1); // copy of Range is not inclusive of the right side

        int i = 0;
        int j = 0;
        int pos = start; // otherwise we always merge from 0
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                numbers[pos++] = left[i++];
            } else {
                numbers[pos++] = right[j++];
            }
        }

        // copy missing elements
        while(i < left.length) {
            numbers[pos++] = left[i++];
        }

        while(j < right.length) {
            numbers[pos++] = right[j++];
        }

        return;
    }
}
