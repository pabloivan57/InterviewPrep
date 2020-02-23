package com.pablan.leetcode.collection.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountSmallerNumbersAfterSelf {

    /**
     * You are given an integer array nums and you have to return a new counts array.
     * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
     *
     * Example:
     *
     * Input: [5,2,6,1]
     * Output: [2,1,1,0]
     * Explanation:
     * To the right of 5 there are 2 smaller elements (2 and 1).
     * To the right of 2 there is only 1 smaller element (1).
     * To the right of 6 there is 1 smaller element (1).
     * To the right of 1 there is 0 smaller element.
     *
     * Pablo's notes:
     * Actually "So instead of sort the number in nums, we sort the indexes of each number." this makes me confused. I feel like the reason why we need the index array is just for the mapping.
     *
     * The general idea is that, we perform the basic merge sort algorithm
     *
     * when you add the elements in the right array to the new sorted array, you need to maintain a counter(rightcount in the code) (add 1 each time), this counter means how many smaller numbers in the right.
     * when you add the elements in the left array to the new sorted array, you need to add the rightcount to the result array
     * Now the problem is that, given a number, you need to know the index in the original array, so that you could update the result array.
     *
     * If there is no duplicate in the array, you can even use a hash map to get the original index of each number. But we could have dup in this problem, so the author used an index array to get the mapping. Instead of put the number in the new sorted array, we could just put the index in the new "sorted index array".
     *
     * Thanks for sharing this solution!
     *
     * Notes 2: This is after I understood, basically do this...
     *
     * everytime a number jumps from right to left, that means you have to add a +1 to all elements
     * that come next from the left. Try it, it works. Do a normal merge sort
     * but everytime you pick a number from left add +rightCount to the array it contains it's original positions
     *
     */
    class Pair {
        int index;
        int val;
        public Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Pair[] arr = new Pair[nums.length];
        Integer[] smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        for (int i = 0; i < nums.length; i++) {
            arr[i] = new Pair(i, nums[i]);
        }
        mergeSort(arr, smaller);
        res.addAll(Arrays.asList(smaller));
        return res;
    }
    private Pair[] mergeSort(Pair[] arr, Integer[] smaller) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid), smaller);
        Pair[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length), smaller);
        for (int i = 0, j = 0; i < left.length || j < right.length;) {
            if (j == right.length || i < left.length && left[i].val <= right[j].val) {
                arr[i + j] = left[i];
                smaller[left[i].index] += j;
                i++;
            } else {
                arr[i + j] = right[j];
                j++;
            }
        }
        return arr;
    }
}
