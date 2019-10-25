package com.pablan.grokking.patterns.twopointer;

public class RemoveKey {

    public int solve(int[] array, int key) {
        int nextElement = 0; // index of the next element which is not key

        for(int i = 0; i < array.length; i++) {
            if(array[i] != key) {
                array[nextElement] = array[i];
                nextElement++;
            }
        }

        return nextElement;
    }
}
