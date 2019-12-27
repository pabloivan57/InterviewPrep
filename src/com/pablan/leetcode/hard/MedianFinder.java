package com.pablan.leetcode.hard;

import java.util.PriorityQueue;

/**
 * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
 *
 * For example,
 * [2,3,4], the median is 3
 *
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 *
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 *
 * Example:
 *
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 *
 *
 * Follow up:
 *
 * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
 * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
 */
public class MedianFinder {

    //maxHeap  of the lows
    PriorityQueue<Integer> lo;
    //minHeap of the highs
    PriorityQueue<Integer> hi;

    /** initialize your data structure here. */
    public MedianFinder() {
        lo = new PriorityQueue<Integer>((a,  b) -> b - a); // max heap of the lows
        hi = new PriorityQueue<Integer>((a, b) -> a - b); // min heap of the  highs
        // by keep this  two balanced the medianw ill be low.pop + high.pop  if  n is  even
        // else low.pop
    }

    public void addNum(int num) {
        lo.offer(num);  // add to max heap
        hi.offer(lo.peek()); //balancing step
        lo.poll();

        if(lo.size() < hi.size()) {
            // rebalance
            lo.offer(hi.peek());
            hi.poll();
        }
    }

    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek()  : (lo.peek() +  hi.peek()) / 2;
    }
}
