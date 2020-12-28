package com.pablan.grokking.patterns.modifiedbinary;

public class NumberRange {

    /**
     * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
     * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
     *
     * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
     *
     * Example 1:
     *
     * Input: [4, 6, 6, 6, 9], key = 6
     * Output: [1, 3]
     * Example 2:
     *
     * Input: [1, 3, 8, 10, 15], key = 10
     * Output: [3, 3]
     * Example 3:
     *
     * Input: [1, 3, 8, 10, 15], key = 12
     * Output: [-1, -1]
     *
     * Pablo's notes: The trick here is to find the min and then the max index. You can
     * do both with binary search. When searching for min... you do normal binary search
     * but when you hit the key then you go to the left. If you are searching for the max then it's
     * the same; just that you go right
     *
     */
    public int[] findRange(int[] arr, int key) {
        int start = findKey(arr, key, true);
        int end = findKey(arr, key, false);

        return new int[] {start, end};
    }

    private int findKey(int[] arr, int key, boolean findMin) {
        int start = 0;
        int end = arr.length - 1;
        int keyIndex = -1;

        while(start <= end) {
            int middle = start + ((end - start) / 2);

            if(key < arr[middle]) {

                // go left
                end = middle - 1;
            } else if(key > arr[middle]) {
                // go right
                start = middle + 1;
            } else if(key == arr[middle]){
                keyIndex = middle;
                if(findMin) {
                    // go left
                    end = middle - 1;
                } else {
                    // go right
                    start = middle + 1;
                }
            }
        }

        return keyIndex;
    }
}
