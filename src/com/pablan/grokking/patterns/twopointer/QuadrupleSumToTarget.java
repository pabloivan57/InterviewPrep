package com.pablan.grokking.patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupleSumToTarget {

    public void solve(int[] arr, int target) {
        Arrays.sort(arr);

        List<List<Integer>> quadruplets = new ArrayList<>();

        for(int i = 0; i < arr.length - 3; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for(int j = i + 1; j < arr.length - 2; j++) {
                if(j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int start = j + 1;
                int end = arr.length - 1;

                while(start < end) {
                    int sum = arr[i] + arr[j] + arr[start] + arr[end];

                    if (sum == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(arr[i]);
                        result.add(arr[j]);
                        result.add(arr[start]);
                        result.add(arr[end]);
                    } else if(sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        return;
    }
}
