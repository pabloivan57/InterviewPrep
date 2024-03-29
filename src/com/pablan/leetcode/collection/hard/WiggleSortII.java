package com.pablan.leetcode.collection.hard;

import java.util.PriorityQueue;

public class WiggleSortII {

    /**
     * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
     *
     * Example 1:
     *
     * Input: nums = [1, 5, 1, 1, 6, 4]
     * Output: One possible answer is [1, 4, 1, 5, 1, 6].
     * Example 2:
     *
     * Input: nums = [1, 3, 2, 2, 3, 1]
     * Output: One possible answer is [2, 3, 1, 3, 1, 2].
     * Note:
     * You may assume all input has valid answer.
     *
     * Follow Up:
     * Can you do it in O(n) time and/or in-place with O(1) extra space?
     *
     * Pablo's notes: This problem is based on dutch flag problem or
     * 3-way-partitioning
     *
     * A better explanation is as follows: Basically you want to arrange the array as
     * peaks and valleys.
     *
     * Peaks will be at positions 1, 3, 5... etc. in other words odd positions
     * Valleys will be at positions 0, 2, 4, 6... etc. In other words even positions
     * If we had split the array in two equal parts. In other words, the median... we can
     * interleave those two parts and get an arrangement. For example:
     *
     * 1 5 1 1 6 4 --> sorted is 1 1 1 5 6 4 = 6 elements, the middle element is (n + 1) / 2
     * That is because of a pattern for even "cuts" where when even numbers you cut through the middle fo a number.
     *
     * 1 2/2 3                 3 +1 / 2 == 2
     * 1  2 / 3 4              4 + 1 / 2 == 2
     * 1  2  3/3  4  5         5 + 1 / 2 == 3
     * 1  2  3 / 4  5  6       6 + 1 / 2 == 3
     *
     * In any case, once we have a ccut for two even sorted parts we can interleave them. We know an algorithm
     * to find that cut. But doing the Kth largest... so we find that number in O(nlogn)
     *
     * And then we do 3 way partitioning
     *
     * 1.- if the number is less than Kth larger? Then put it in even position (will be valley)
     * 2.- If the number is more than Kth larger? Then put it in odd positioon (will be peak)
     */
    public void wiggleSort(int[] nums) {

        // Step 1: find median
        int median = findKthLargest(nums, (nums.length + 1 / 2));

        // Step 2: 3 way partitioning around the median
        int n = nums.length;
        int i = 1; //(2) elements larger than the 'median' are put into the first odd slots
        int j = (n - 1) / 2 * 2; //(1) elements smaller than the 'median' are put into the last even slots
        int x = j;

        for(int k = 0; k < n;k++){
            if(nums[x] > median){
                swap(nums, x, i);
                i += 2;
            } else if(nums[x] < median){
                swap(nums, x, j);
                j = j - 2;
                x = x - 2;
                if(x < 0) x = n / 2 * 2 - 1;
            } else {
                x = x - 2;
                if(x < 0) x = n / 2 * 2 - 1;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    // Find Kth largest in O(nlogn)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

        for(int i = 0; i < nums.length; i++) {
            minHeap.offer(nums[i]);

            while(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // At this point I will have the k largest in the array, just need the smallest
        return minHeap.poll();
    }
}
