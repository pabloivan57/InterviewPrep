package com.pablan.leetcode.collection.google;

public class PeakIndexMountainArray {

    /**
     * Let's call an array A a mountain if the following properties hold:
     *
     * A.length >= 3
     * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
     * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
     *
     * Example 1:
     *
     * Input: [0,1,0]
     * Output: 1
     * Example 2:
     *
     * Input: [0,2,1,0]
     * Output: 1
     *
     * Pablo's notes: The question tells you that there is only one peak, Therefore if we compare two numbers at a time
     * A < B will be true until at one point it is false
     * true, true, true, true, false, false, false. Doing a basic binary search gives you this value
     */
    public int peakIndexInMountainArray(int[] A) {
        // Apply binary search
        int start = 0;
        int end = A.length - 1;

        return search(start, end, A);
    }

    public int search(int start, int end, int[] A) {
        while(start < end) {
            int middle = start + ((end - start) / 2);

            if(A[middle] < A[middle + 1]) {
                start = middle + 1;
            } else {
                end = middle;
            }
        }

        return start;
    }


    // This approach works for multiple peaks and valleys, it finds any number that is a peak
    public int search2(int start, int end, int[] A) {
        while(start <= end) {
            int middle = start + ((end - start) / 2);

            // Case 1: is peak
            if(A[middle - 1] < A[middle] && A[middle] > A[middle + 1]) {
                return middle;
            }
            // else if it's descending
            else if(A[middle - 1] > A[middle] && A[middle] > A[middle + 1]) {
                // find peak on the left
                int result = search2(start, middle, A);
                if(result != -1) {
                    return result;
                } else {
                    // Search right
                    return search2(middle + 1, end, A);
                }
            } else {
                int result = search2(middle + 1, end, A);
                if(result != 1) {
                    return  result;
                } else {
                    // Search left
                    return search2(start, middle, A);
                }
            }
        }

        return -1;
    }
}
