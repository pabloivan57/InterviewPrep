package com.pablan.grokking.patterns.modifiedbinary;

public class SearchBitonicArray {

    public int search(int arr[], int key) {
        int maxIndex = findMax(arr);
        int keyIndex = orderAgnosticBinarySearch(arr, key, 0, maxIndex);
        if(keyIndex != -1) {
            return keyIndex;
        }
        return orderAgnosticBinarySearch(arr, key, maxIndex + 1, arr.length - 1);
    }

    public int findMax(int arr[]) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // low and high will be the same
        return low;
    }

    public int orderAgnosticBinarySearch(int arr[], int key, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == key) {
                return mid;
            }

            if(arr[start] < arr[end]) { // ascending order
                if(key > arr[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (arr[start] > arr[end]) { // descending order
                if(key > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return  -1; // Element not found
    }

    public int searchPablo(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while(low < high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == key) {
                return mid;
            } else if(arr[mid] > arr[mid + 1]) {
                if(key > arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                if(key < arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        // at the end of the array low == start
        return arr[low] == key ? low : -1;
    }
}
