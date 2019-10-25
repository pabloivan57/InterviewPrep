package com.pablan.grokking.patterns.topk;

import java.util.*;

class Entry1 {
  int key;
  int value;

  public Entry1(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

public class KClosestElements {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int closetIndexToX = binarySearch(arr, x);
        int low = closetIndexToX - k;
        int high = closetIndexToX + k;
        low = Math.max(low, 0);
        high = Math.min(high, arr.length - 1);

        PriorityQueue<Entry1> minHeap = new PriorityQueue<>((a, b) -> a.key -  b.key);

        for(int i = low; i < high; i++) {
            minHeap.add(new Entry1(Math.abs(arr[i] - x), i));
        }

        // we need the top 'K' elements having smallest difference from 'X'
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(arr[minHeap.poll().value]);
        }

        Collections.sort(result);
        return result;
    }

    private int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while(low <= high) {
            int middle = low + (high - low) / 2;

            if(arr[middle] == target) {
                return middle;
            } else if(arr[middle] < target) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        // Normally when not found here we return -1,
        // But when low exhaust all it's options towards the right
        // then we usually end up in arr.length - 1 + 1 = out of bounds
        if(low > 0) {
            return low - 1;
        }

        return low;
    }

    public List<Integer> findClosestElementsTwoPointer(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        int closestIndexToX = binarySearch(arr, x);
        int leftPointer = closestIndexToX;
        int rightPointer = closestIndexToX + 1;

        for(int i = 0; i < k; i++) {
            // Boundary check
            if(leftPointer >= 0 && rightPointer < arr.length) {
                int diff1 = Math.abs(arr[leftPointer] - x);
                int diff2 = Math.abs(arr[rightPointer] - x);

                if(diff1 > diff2) {
                    result.addLast(arr[rightPointer]);
                    rightPointer++;
                } else {
                    result.addFirst(arr[leftPointer]);
                    leftPointer--;
                }
            } else if(leftPointer >= 0){
                result.addFirst(arr[leftPointer]);
                leftPointer--;
            } else {
                result.addLast(arr[rightPointer]);
                rightPointer++;
            }
        }

        return result;
    }
}
