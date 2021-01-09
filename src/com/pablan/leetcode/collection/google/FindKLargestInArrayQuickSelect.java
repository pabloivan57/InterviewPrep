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
     *
     * Pablo's notes: The optimal solution uses Quick Select to do this, that is because you can cut
     * the time to O(n) best case where you pick position as pivot or O(n ^ 2) worst case using quick store.
     * The cool thing about this is that Quick sort
     * put's 1 element in the right position at a time. So we use that to our advantage, for example:
     * 3,2,1,5,6,4 k = 2 is asking for the 2 largest element if the array is sorted
     * Or in other words, position 4
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
        int pivot_index = partition(nums, 0, nums.length - 1);
        int position_to_find = nums.length - k; // Why not nums.length - 1 - k? That is because
                                                // nums.length - 1 includes an element, so now you
                                                // have to move k-1 spaces to the left. For example:
                                                //  3, 2, 1, 5, 6, 4 and k = 2
                                                //  k = 1 is position n - 1 or 5
                                                //  k = 2 is position n - 1 - 1 or 4.
                                                // In other words we are looking at element on index 4 or (n - k)
                                                // or n - 1 - (k - 1)

        while(pivot_index != position_to_find) {
            pivot_index = partition(nums, 0, nums.length - 1);
            if(pivot_index < position_to_find) {
                pivot_index = partition(nums, pivot_index + 1,nums.length - 1);
            } else {
                pivot_index = partition(nums, 0, pivot_index - 1);
            }
        }

        return pivot_index;
    }

    private int partition(int[] nums, int low, int high) {
        // we use middle for pivot
        int pivot = ((high - low) / 2);
        int pivotValue = nums[pivot];

        // swap pivot to the end
        swap(pivot, high, nums);
        int i = low - 1;
        for(int j = low; j < high; j++) {
            if(nums[j] < pivotValue) {
                swap(++i, j, nums);
            }
        }

        // swap back pivot
        swap(pivot, high, nums);
        return pivot;
    }

    private void swap(int a, int b, int[] nums) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }
}
