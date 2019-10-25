package com.pablan.grokking.patterns.twoheaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findSlidingWindowMedian(int nums[], int k) {
        double[] result = new double[nums.length - k + 1];

        /**
         * nums.length - k + 1 explanation
         *
         * You just now that you have to pick k elements at a time... but if you start from 0
         * what index is that?
         *
         * for k = 2, we will have 2 elements at index i = 1
         *
         * i (1) - 2 + 1 = 0
         * i (2) - 2 + 1 = 1
         * i (3) - 2 + 1 = 2
         *
         * But since we are picking k elements we have to stop at length - k + 1
         *
         * [0,1,2,3,4] n = 5
         *
         */
        for(int i = 0; i < nums.length; i++) {
            if(maxHeap.isEmpty() || maxHeap.peek() >= nums[i]) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }

            rebalanceHeaps();

            if(i - k + 1 >= 0) { // if we have at least 'k' elements in the sliding window, trick to don't do this the first time
                // add the median to the result
                if(maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = (maxHeap.peek() + minHeap.peek()) / 2.0f;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }

                // remove the element going out of the sliding window
                int elementToBeRemoved = nums[i - k + 1];
                if(elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved); // This operation takes O(n) which make the overall complexity O(N * K)
                } else {
                    minHeap.remove(elementToBeRemoved);
                }

                rebalanceHeaps();
            }
        }

        return result;
    }

    private void rebalanceHeaps() {
        if(maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if(maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}
