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
     *  is a textbook algorithm, For better explanation read the bottom. However it goes like this
     *
     *  1.- Find the first number that breaks a decreasing sequence from right to left, call it pivot
     *  2.- Now, find the very first element from right to left that is more than pivot.
     *      - Notice how, step 1 guarantees the right side of pivot is sorted in decreasing order
     *      - This allows you to do a while(j >= 0) if pivot > j pick j
     *      - swap (pivot and j)
     *      - reverse the list on the right side to pivot. Why? -> well that's because the first permutation of a descending sequence is the reverse of that list
     *        I.E: 3 2 1 is already the highest permutation (Try it... no number swap will have a greater number) --> so it goes to 1 2 3
     *
     * Key concept to consider here is that the permutations are "lexicographically" sorted. Meaning by that if
     * we were to generate all permutations we would try to go from less -> more. Consider the example
     * 1 2 3. How can we generate permutations for those numbers?
     *
     * 1.- _ _ _ --> We place the lowest first, because it's lexicographically
     * 2.- 1 _ _ --> Now 2
     * 3.- 1 2 _ --> We only have left 3 so we place it
     * 4.- 1 2 3 --> We deplete our option so we backtrack to consider the other alternative at step 3
     * 5.- 1 3 _ --> We already tried 2 so we go for 3 now
     * 6.- 1 3 2 --> 2 is the only one left so we place it... Now why is this the "NEXT" permutation?
     *
     * You have to notice that when you exhaust lexicographically possibilities the result will be in descending order
     *  1 2 3 --> the last is 3 2 1, for 2 3 the last is 3 2
     *
     *  So here is how you go about the algorithm... find the very first number from the right that breaks the descending order
     *  1 4 6 9 8 7 --> in this case 6. Why? imagine as you were generating the permutations. you saw how you "select" a number each time
     *
     *  1 _ _ _ _ _
     *  1 4 _ _ _ _
     *  1 4 6 _ _ _
     *   .... bunch of permutations among the 3 number 9 8 7
     *  1 4 6 9 8 7 --> this is the last permutation when you "lock" the left side  to 1 4 6 _ _ _
     *  Imagine you are back at 1 4 6 _ _ _ (and the right side [7 8 9] is sorted from high to low)
     *  Because the question is asking for 'lexicographically' order then you know that the next choice
     *  should be the smallest number in the right side [7 8 9], in other words 7
     *  1 4 7 _ _ _ [now right side has 6 9 8] which number should be placed next? 6 right?
     *
     *  So here is what we can do
     *  1 4 6 9 8 7 --> we know that position of 6 is the next number we have to "swap"
     *  1 4 7 9 8 6 --> But... we know the right side should be sorted from less -> more. Cool so let's swap right side
     *  1 4 7 6 8 9. Perfect! this is the next lexicographically sorted permutation
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        // Step 1. Find the sequence that is exhausted from right to left (descending order)
        int pivot = -1;
        for(int i = nums.length - 2; i >= 0; i++) {
            if(nums[i] < nums[i + 1]) {
                // This is ascending order, therefore the place where we should swap
                pivot = i;
                break;
            }
        }

        // Step 2. Swap last number with pivot
        if(pivot != -1) {
            // the very first number from the right side that is more than pivot
            // This is done for edge cases where there are a bunch of number off the same size
            for(int i = nums.length - 1; i > pivot; i--) {
                if(nums[pivot] > nums[i]) {
                    swap(pivot, i, nums);
                    break;
                }
            }
        }


        // Step 3. reverse the right side of the array
        reverse(pivot + 1, nums.length - 1, nums);
    }

    private void swap(int a, int b, int[] nums) {
        int aux = nums[a];
        nums[a] = nums[b];
        nums[b] = aux;
    }

    private void reverse(int start, int end, int[] nums) {
        while(start <= end) {
            swap(start, end, nums);
            start++;
            end--;
        }
    }

}
