package com.pablan.grokking.patterns.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public List<List<Integer>> test(int arr[]) {
        Arrays.sort(arr);

        List<List<Integer>> triplets = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }

            searchTriplet(arr, i + 1, -arr[i], triplets);
        }

        return triplets;
    }

    private void searchTriplet(int arr[], int start, int target, List<List<Integer>> triplets) {

        int ptr1 = start;
        int ptr2 = arr.length - 1;

        while(ptr1 < ptr2) {
            if(arr[ptr1] + arr[ptr2] == target) {
                List<Integer> triplet = new ArrayList<>();
                triplet.add(arr[ptr1]);
                triplet.add(arr[ptr2]);
                triplet.add(-target);

                triplets.add(triplet);
                return;
            }

            if (arr[ptr1] + arr[ptr2] > target) {
                ptr2--;
            } else {
                ptr1++;
            }
        }

        return;
    }
}
