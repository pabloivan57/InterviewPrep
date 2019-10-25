package com.pablan.grokking.patterns.twoheaps;

import java.util.PriorityQueue;

public class MedianOfStream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfStream() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void insertNum(int n) {
        if(maxHeap.isEmpty() || maxHeap.peek() >= n) {
           maxHeap.add(n);
        } else {
            minHeap.add(n);
        }

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }

    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // we have even number of elements, take the average of middle two elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // because max-heap will have one more element than the min-heap
        return maxHeap.peek();
    }
}
