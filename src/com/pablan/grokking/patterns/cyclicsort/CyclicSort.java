package com.pablan.grokking.patterns.cyclicsort;

public class CyclicSort {


    /**
     *  We are given an array containing ‘n’ objects. Each object, when created, was assigned a
     *  unique number from 1 to ‘n’ based on their creation sequence.
     *  This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.
     *
     * Write a function to sort the objects in-place on their creation sequence number in
     * O(n)
     * O(n) and without any extra space. For simplicity, let’s assume we are passed an integer array
     * containing only the sequence numbers, though each number is actually an object.
     *
     * Example 1:
     *
     * Input: [3, 1, 5, 4, 2]
     * Output: [1, 2, 3, 4, 5]
     * Example 2:
     *
     * Input: [2, 6, 4, 3, 1, 5]
     * Output: [1, 2, 3, 4, 5, 6]
     * Example 3:
     *
     * Input: [1, 5, 6, 4, 3, 2]
     * Output: [1, 2, 3, 4, 5, 6]
     */
    public void sort(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            int j = nums[i] - 1;

            if(nums[i] != nums[j]) {
                swap(i, j, nums);
            } else  {
                i++;
            }
        }
    }

    private void swap(int p1, int p2, int nums[]) {
        int aux = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = aux;
    }
}
