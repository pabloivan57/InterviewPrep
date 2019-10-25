package com.pablan.grokking.patterns.modifiedbinary;

public class SearchInfiniteSortedArray {

    public int search(ArrayReader reader, int key) {
        int low = 0;
        int high = 1;

        while(reader.get(high) < key) {
            int newStart = high + 1;
            high += (high - low + 1) * 2; // increase to double the bounds size
            low = newStart;
        }

        return binarySearch(reader, key, low, high);
    }

    public int binarySearch(ArrayReader reader, int key, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(reader.get(mid) > key) {
                end = mid - 1;
            } else if (reader.get(mid) < key) {
                start = start + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
