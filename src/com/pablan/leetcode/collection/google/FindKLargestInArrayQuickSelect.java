package com.pablan.leetcode.collection.google;

import java.util.PriorityQueue;
import java.util.Random;

public class FindKLargestInArrayQuickSelect {

    int[] nums;

    /**
     * Find the kth largest element in an unsorted array.
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     *
     * Example 1:
     *
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     *
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     */
    public int findKthLargest(int[] nums, int k) {
        findKthLargestWithHeaps(nums, k);
        return findKthLargestWithQuickSelect(nums, k);
    }

    public int findKthLargestWithHeaps(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for(int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);

            while(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    private int findKthLargestWithQuickSelect(int[] nums, int k) {
        int pivot_index = partition(0, nums.length - 1, nums);
        int position_to_search = nums.length - k;

        while(pivot_index != position_to_search) {
            if(pivot_index < position_to_search) {
                pivot_index = partition(pivot_index + 1, nums.length - 1, nums);
            } else {
                pivot_index = partition(0, pivot_index - 1, nums);
            }
        }

        return nums[pivot_index];
    }

    private int partition(int low, int high, int[] nums) {

        // let's do /2 for now
        int pivotIndex =  low + ((high - low) / 2);
        int pivotValue = nums[pivotIndex];

        // move pivot to the end
        swap(pivotIndex, high, nums);

        // move everything between low / high to be less than pivot
        // and use a variable to remember the last index which was less than pivot
        int less = low - 1;
        for(int i = low; i < high; i++) {
            if(nums[i] < pivotValue) {
                swap(i, ++less, nums);
            }
        }

        // move the pivot to the position where it is supposed to be
        swap(++less, high, nums);

        return less;
    }


    public void swap(int a, int b, int[] nums) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
