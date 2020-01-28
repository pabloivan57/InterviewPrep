package com.pablan.leetcode.collection.google;

public class NextPermutation {
    /**
     * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
     *
     * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
     *
     * The replacement must be in-place and use only constant extra memory.
     *
     * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
     *
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     *
     *  Pablo's notes: Good explanation in Youtube https://www.youtube.com/watch?v=quAS1iydq7U, this
     *  is a textbook algorithm. However it goes like this:
     *
     *  1.- Find the first number that breaks a decreasing sequence from right to left, call it pivot
     *  2.- Now, find the very first element from right to left that is more than pivot.
     *      - Notice how, step 1 guarantees the right side of pivot is sorted in decreasing order
     *      - This allows you to do a while(j >= 0) if pivot > j pick j
     *      - swap (pivot and j)
     *      - reverse the list on the right side to pivot. Why? -> well that's because the first permutation of a descending sequence is the reverse of that list
     *        I.E: 3 2 1 is already the highest permutation (Try it... no number swap will have a greater number) --> so it goes to 1 2 3
     *
     *  Note: How do you create a permutation? in ascending order? let's see for 1 2 3
     *
     *  1 2 3 -> 1 3 2
     *  1 3 2 -> 2 1 3 (you always ground the smallest of the choices, in this case after grounding 2 you chose 1 from (1, 3) 213 < 231
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // Step 1 find pivot
        int pivot = -1;
        for(int j = nums.length - 2; j>=0; j--) {
            if(nums[j] < nums[j + 1]) {
                pivot = j;
                break;
            }
        }

        // Step 2 find the very first element on the right side that is more than pivot
        if(pivot != -1) {
            for (int j = nums.length - 1; j > pivot; j--) {
                if (nums[j] > nums[pivot]) {
                    swap(pivot, j, nums);
                    break;
                }
            }
        }

        // Step 3 reverse the right side
        reverse(pivot + 1, nums.length - 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int aux = nums[i];
        nums[i] = nums[j];
        nums[j] = aux;
    }

    private void reverse(int i, int j, int[] nums) {
        while(i <= j) {
            swap(i, j, nums);
            i++;
            j--;
        }
    }
}
