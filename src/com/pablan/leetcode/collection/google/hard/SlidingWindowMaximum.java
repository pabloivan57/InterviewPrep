package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class SlidingWindowMaximum {

    /**
     * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     *
     * Return the max sliding window.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
     * Output: [3,3,5,5,6,7]
     * Explanation:
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];

        int max = Integer.MIN_VALUE;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            while(windowEnd - windowStart > k) {
                windowStart++;
            }

            max = Math.max(max, nums[windowEnd]);

            // if I reached the window size
            if(windowEnd >= k - 1) {
                result[windowEnd - k + 1] = max;
            }
        }

        return result;
    }

    /**
     *  This solution uses a deque, the idea is a follows. you have the elements
     *  by index in a deque (you push elements to left and poll to the right).
     *  At each step you peek and remove the left indexes that are outside the window (k - k + 1)
     *  Also at each step you are going to put the current element to the right of the queue (BUT!)
     *  you will first remove everything in the queue that is less than current. That way
     *  you always keep with elements sorted from max to min. For example:
     *  [1 3 -1 -3  5] k = 3
     *  1.- check 1(index) < 1 - k + 1? 1 > -1 nope, do noothing
     *  2.- remove everything in the queue less than 1
     *  3.- push index 0
     *  4.- check 0(first index from left) < 1(current index) - k +1 ? 0 < -1 nope
     *  5.- remove everything less than 3 -> remove [1]
     *  6.- push index 1. Queue now looks like [1]
     *  7.- check 1(first index from left) < 2 (current index) - k +1 ? 1 < 0 nope
     *  8.- remove everything less than - 1, no action
     *  9.- push index 2 (val -1)
     *  10.- Check 1(first index from left) < 3(current index) -k + 1? 1 < 1 nope
     *  11.- remove everything less than -3, no action queue looks like this [1 2] --> represents [3 -1]
     *  12.- push index 3 (val -3) --> queue looks like [1 2 3]
     *  13.- check 1 (first index from left) < 4(current index) - k +1? 1 < 2 yes, remove top. queue looks like [2 3]
     *  14.- Remove everything less than 5, remove 2 and 3. because 3 and -1 < 5. Queue now looks like []
     *  15.- push index 4 (val 5) --> queue looks like [4]
     */
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> dequeue = new ArrayDeque<>();

        for(int i = 0; i < nums.length; i++) {
            // step 1 check that left index is less than 1
            while(!dequeue.isEmpty() &&dequeue.peek() < i - k + 1) {
                dequeue.poll();
            }

            // step 2 remove everything less than current
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) {
                dequeue.pollLast();
            }

            // step 3 push
            dequeue.offer(i);

            // step 4 if we are in a position where we can process result
            if(i - k + 1 >= 0) {
                result[i - k + 1] = nums[dequeue.peek()];
            }
        }

        return result;
    }
}
