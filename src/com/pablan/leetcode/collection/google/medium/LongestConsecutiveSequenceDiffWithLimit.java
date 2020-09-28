package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveSequenceDiffWithLimit {

    /**
     *  Given an array of integers nums and an integer limit,
     *  return the size of the longest non-empty subarray such that the absolute difference
     *  between any two elements of this subarray is less than or equal to limit.
     *
     *  Example 1:
     *
     *  Input: nums = [8,2,4,7], limit = 4
     *  Output: 2
     *  Explanation: All subarrays are:
     *  [8] with maximum absolute diff |8-8| = 0 <= 4.
     *  [8,2] with maximum absolute diff |8-2| = 6 > 4.
     *  [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
     *  [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
     *  [2] with maximum absolute diff |2-2| = 0 <= 4.
     *  [2,4] with maximum absolute diff |2-4| = 2 <= 4.
     *  [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
     *  [4] with maximum absolute diff |4-4| = 0 <= 4.
     *  [4,7] with maximum absolute diff |4-7| = 3 <= 4.
     *  [7] with maximum absolute diff |7-7| = 0 <= 4.
     *  Therefore, the size of the longest subarray is 2.
     *
     *  Example 2:
     *
     *  Input: nums = [10,1,2,4,7,2], limit = 5
     *  Output: 4
     *  Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
     *  Example 3:
     *
     *  Input: nums = [4,2,2,2,4,4,2,2], limit = 0
     *  Output: 3
     *
     *  Pablo's notes: Simple variable window 'key is consecutive' where you are interested in max / min pairs
     *  so simply keep track of them. You do that using a minHeap and maxHeap
     */
    public int longestSubarray(int[] nums, int limit) {
        int windowStart = 0;

        int maxWindowSize = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> a - b);
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            maxHeap.offer(nums[windowEnd]);
            minHeap.offer(nums[windowEnd]);

            while(Math.abs(maxHeap.peek() - minHeap.peek()) > limit) {
                maxHeap.remove(nums[windowStart]);
                minHeap.remove(nums[windowStart]);
                windowStart++;
            }

            int windowSize = windowEnd - windowStart + 1;
            if(maxWindowSize < windowSize) {
                maxWindowSize  = windowSize;
            }
        }

        return maxWindowSize;
    }

    public int longestSubarrayDeque(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}
