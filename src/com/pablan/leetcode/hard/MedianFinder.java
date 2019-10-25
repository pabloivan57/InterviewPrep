package com.pablan.leetcode.hard;

import java.util.PriorityQueue;

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
