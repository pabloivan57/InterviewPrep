package com.pablan.grokking.patterns.twopointer;

public class DutchNationalFlag {

    public void solve(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        for (int i = 0; i <= high;) {
            if(arr[i] == 0) {
                int exchange = arr[low];
                arr[low] = arr[i];
                arr[i] = exchange;
                low++;
                i++;
            } else if(arr[i] == 2) {
                int exchange = arr[high];
                arr[high] = arr[i];
                arr[i] = exchange;
                // decrement 'high' only, after the swap the number at index 'i' could be 0, 1 or 2
                high--;
            } else {
                i++;
            }
        }
    }
}
