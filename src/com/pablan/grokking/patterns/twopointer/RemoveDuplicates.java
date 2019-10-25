package com.pablan.grokking.patterns.twopointer;

public class RemoveDuplicates {

    public int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }
}
