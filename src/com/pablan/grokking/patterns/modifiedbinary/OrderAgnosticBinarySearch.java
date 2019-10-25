package com.pablan.grokking.patterns.modifiedbinary;

public class OrderAgnosticBinarySearch {

    public int search(int arr[], int key) {
        int low = 0;
        int high = arr.length - 1;
        int middle;

        boolean ascending = arr[0] < arr[arr.length - 1];

        while(low <= high) {
            middle = low + (high - low) / 2;

            if(arr[middle] == key) {
                return middle;
            } else if (arr[middle] > key) {
                if(ascending) {
                    // search for lower numbers
                    high = middle - 1;
                } else {
                    // search for higher numbers
                    low = middle + 1;
                }
            } else {
                if(ascending) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }

        return -1;
    }
}
