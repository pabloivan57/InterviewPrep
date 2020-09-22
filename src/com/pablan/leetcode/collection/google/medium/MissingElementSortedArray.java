package com.pablan.leetcode.collection.google.medium;

public class MissingElementSortedArray {

    /**
     * Given a sorted array A of unique numbers, find the K-th missing number
     * starting from the leftmost number of the array.
     *
     * Example 1:
     *
     * Input: A = [4,7,9,10], K = 1
     * Output: 5
     * Explanation:
     * The first missing number is 5.
     * Example 2:
     *
     * Input: A = [4,7,9,10], K = 3
     * Output: 8
     * Explanation:
     * The missing numbers are [5,6,8,...], hence the third missing number is 8.
     * Example 3:
     *
     * Input: A = [1,2,4], K = 3
     * Output: 6
     * Explanation:
     * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
     *
     * Pablo's notes: This takes advantage of the fact that they are sorted. Look at the example
     *
     * [1....5], no matter how many elements in between you know there are 5 numbers in there  [1, 2, 3, 4, 5]
     * 5 - 1 = 4, so you add a +1 to account for that
     *
     * So, let's say you're asked k = 4. You know  there are  only 3 missing and you will be left with 1 k, therefore
     * you return the next in the series 6 or 5 + k(1).
     *
     * Now let's say you have 6 missing in the series and k 4. That's when you take advantage of binary search. Let's do
     * this same process with the middle number. (nums[middle] - nums[left] [a.k.a  how many should be in there])
     * - (how many positions I have)
     */
    public int missingElement(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        int missing = nums[right] - nums[left] - (right - left); // This means how many should be there compared
                                                                  // to how many I have

        if(missing < k) {
            return nums[right] + k  - missing; //  If they want example 3 where I have more k than missing numbers
        }

        while(left <= right) {
            int middle = left + ((right - left) / 2);

            missing = nums[middle] - nums[left] - (middle - left);

            if(missing > k) {
                // too  many missing, we need to find the far left
                right =  middle;
            } else {
                k =  k  - missing; // I know I have less than k missing on the left. Let me check if the right side
                                   // has the other ones missing
                left = middle  + 1;
            }
        }

        return nums[left] + k;
    }
}
