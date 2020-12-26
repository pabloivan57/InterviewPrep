package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsequenceSum {

    /**
     *  Given an integer array nums and an integer k,
     *  return the maximum sum of a non-empty subsequence of that array such that for every two consecutive
     *  integers in the subsequence, nums[i] and nums[j], where i < j, the condition j - i <= k is satisfied.
     *
     *  A subsequence of an array is obtained by deleting some number of elements (can be zero) from the array,
     *  leaving the remaining elements in their original order.
     *
     *  Example 1:
     *
     *  Input: nums = [10,2,-10,5,20], k = 2
     *  Output: 37
     *  Explanation: The subsequence is [10, 2, 5, 20].
     *  Example 2:
     *
     *  Input: nums = [-1,-2,-3], k = 1
     *  Output: -1
     *  Explanation: The subsequence must be non-empty, so we choose the largest number.
     *  Example 3:
     *
     *  Input: nums = [10,-2,-10,-5,20], k = 2
     *  Output: 23
     *  Explanation: The subsequence is [10, -2, -5, 20].
     *
     *
     *  Pablo's notes: This is a tricky questions, and to be honest it doesn't make sense when you don't
     *  have negative numbers. That is because if you have only positives then could potentially select
     *  all of the, consecutive and it will give you the max number. So now, think in terms of negatives
     *  if you select A[i] and it is a negative it could impact the max result. Therefore you always want to
     *  remember numbers in the window in case you are better off skipping that negative. Here is where
     *  a max deque comes in handy. You will remember sums sorted from max to min from within the window
     *  we are given. Once we are past that window, we can't select that sum anymore. Here is an example that is
     *  very helpful to understand
     *
     *  [10, -2, -10, -5, 20]
     *
     *  1.- Start at 10, max sum is 10
     *  2.- Now move to -2, if you select that one you can have a max of 8 (10 - 2)
     *  3.- Now move to -10, it doesn't make sense to try adding the last number, because we now that skipping the
     *      last number had a better result (10 - 10) > (8 - 10)
     *  4.- Now go to -5, the original (10) that we got at index 0 is oout of the window... so now
     *      what happens if we select -2? doesn't make sense because in step 3 we determined that -10 is a better option
     *      than -2 to get max numbers
     *  5.- In other words, at each step we keep a descending queue for the max sums !within the window!
     *
     *  10 -2 --> queue will look like [10, 8]
     *  10 -2 -10 -> queue will look like [10, 8, 0]
     *  10 -2 -10 -5 -> queue will look like [8, 3] -> 10 is out of range, 3 is a new max... therefore we discard 0
     *  10 -2 -10 -5 20 -> queue will look like [23] -> 8 is out of range, 23 is a new max... therefore discard 8
     */
    public int constrainedSubsetSum(int[] nums, int k) {
        int result = 0;
        int[] sums = new int[nums.length];

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            // check if index in deque is out of window, if it is pop it
            while(!deque.isEmpty() && deque.peek() > i - k + 1) {
                deque.poll();
            }

            // try to add the max sum within range for this index
            sums[i] = nums[i];
            if(!deque.isEmpty()) {
                sums[i] += sums[deque.peek()];
            }
            // remove everything less than sums[i]
            while(!deque.isEmpty() && sums[deque.peekLast()] < sums[i]) {
                deque.pollLast();
            }

            // calculate max
            result = Math.max(result, sums[i]);
            deque.offer(i);
        }

        return result;
    }
}
