package com.pablan.grokking.patterns.modifiedbinary;

public class CeilingOfANumber {

    /**
     *  Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
     *  The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
     *
     *  Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
     *
     *  Example 1:
     *
     *  Input: [4, 6, 10], key = 6
     *  Output: 1
     *  Explanation: The smallest number greater than or equal to '6' is '6' having index '1'.
     *  Example 2:
     *
     *  Input: [1, 3, 8, 10, 15], key = 12
     *  Output: 4
     *  Explanation: The smallest number greater than or equal to '12' is '15' having index '4'.
     *  Example 3:
     *
     *  Input: [4, 6, 10], key = 17
     *  Output: -1
     *  Explanation: There is no number greater than or equal to '17' in the given array.
     *  Example 4:
     *
     *  Input: [4, 6, 10], key = -1
     *  Output: 0
     *  Explanation: The smallest number greater than or equal to '-1' is '4' having index '0'.
     */
    public int searchCeilingOfANumber(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        // edge case, if the key is too high and not in the array
        // the algorithm will reach the far right and check if number is more than key
        // because it's now it will go beyond bound and while loop will exit. However,
        // the low at this point will be arr.length + 1 which is incorrect because problem
        // wants -1
        if(key > arr[high]) {
            return -1;
        }

        while(low <= high) {
            int middle = low + ((high - low) / 2);

            // ceiling of a number is that same number
            if(arr[middle] == key) {
                return middle;
            }

            if(arr[middle] > key) {
                // search left
                high = middle - 1;
            } else {
                // search right
                low = middle + 1;
            }
        }

        // binary search will stop when low == high. that will be the ceiling if
        // number is not found on array. return low or high
        return low;
    }
}
