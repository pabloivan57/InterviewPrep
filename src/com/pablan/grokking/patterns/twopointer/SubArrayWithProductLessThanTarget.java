package com.pablan.grokking.patterns.twopointer;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithProductLessThanTarget {

    public List<List<Integer>> solve(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int product = 1;
        int left = 0;

        for(int right = 0; right < arr.length - 1; right++) {
            product *= arr[right];

            // It's normal sliding window, what we do is we keep a sum
            // under the required value, in this part we are just 'substracting'
            // the value when we move the window
            while(product >= target && left < arr.length) {
                product /= arr[left];
                left++;
            }

            List<Integer> tempList = new ArrayList<>();
            for(int i = right; i >= left; i--) {
                //The window size is the 'subarray' less than target
                // Also all the vals in that window will be less than target
                tempList.add(arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }

        return result;
    }
}
