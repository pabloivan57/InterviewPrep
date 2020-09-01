package com.pablan.leetcode.collection.google.hard;

public class SplitArrayLargestSum {

    /**
     *  Given an array nums which consists of non-negative integers and an integer m,
     *  you can split the array into m non-empty continuous subarrays.
     *
     * Write an algorithm to minimize the largest sum among these m subarrays.
     *
     * Example 1:
     *
     * Input: nums = [7,2,5,10,8], m = 2
     * Output: 18
     * Explanation:
     * There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8],
     * where the largest sum among the two subarrays is only 18.
     * Example 2:
     *
     * Input: nums = [1,2,3,4,5], m = 2
     * Output: 9
     *
     * Example 3:
     *
     * Input: nums = [1,4,4], m = 3
     * Output: 4
     *
     * Pablo's notes: Minimize the largest sum means: "With the least amount of numbers,
     * maximize the sum you can get"
     *
     * Let's start from a target number, this is important. Given:
     *
     * [7, 2, 5, 10, 8]. Find a split of numbers that never goes beyond 15. A way to do that
     * is simply greedy
     * 7 < 15 ? yes, keep going
     * 7 + 2 < 15 ? yes, keep going
     * 7 + 2 + 5 < 15 ? yes, keep going
     * 7 + 2 + 5 + 10 < 15? nope, that means 10 can't go to last array. Start a new subarray
     * [7, 2, 5]
     * [10] + 8 < 15 ? nope, that means 8 can't go to last array. Start a new subarray
     * [7, 2, 5] [10] [8] that means that to have contiguous subarrays < 15 you need at least 3 partitions
     *
     * Now... going back too the problem:
     *
     *
     * http://shirleyisnotageek.blogspot.com/2016/10/split-array-largest-sum.html
     *
     * The problem can be solved by using binary search, which is a quite brilliant way.
     * If m equals length of the array (remember this refers to pieces not how many cuts),
     * the largest sum should be the maximum among the elements.
     * If m equals 1, then it should be the sum of all elements in the array.
     * Now the maximum sum of a subarray should be between these two numbers.
     *
     * The idea is to using binary search and find this minimum maximum sum.
     * We set left to the maximum element of the array and right to the sum of the array.
     * First we choose the mid of these two and find if there exist m subarrays that have largest
     * sum less than or equal to mid. If we can find such split, we know we probably can do better.
     * So we set right to mid. We keep on doing this until we find a value that we cannot
     * get by splitting the array to m subarrays, i.e., the number is too small that we need to
     * split the array further more. Now we increase left to mid + 1. When left = right, we find the number.
     *
     *
     * [7, 2, 5, 10, 8] m = 2
     *
     * left = 10, right = 32, mid = 21 => [7, 2, 5], [10, 8] m = 2, valid look left next step
     *
     * left = 10, right = 21, mid = 15 => [7, 2, 5], [10],[8], m = 3 not valid  look right next step
     *
     * left = 16, right = 21, mid = 18 => [7, 2], [10, 8]  m = 2, valid look left next step
     *
     * left = 16, right = 18, mid = 17 => [7, 2], [10, 5],[8] m = 3, not valid
     *
     * left = 18, right = 18 => return 18
     *
     *
     * (Just a guess), the minimum maximum sum should be the mid number when one of the subarrays has the sum equal to it.
     */
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;

        for(int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }

        while(left < right) {
            int middle = left + ((right - left) / 2);
            if(isPossible(middle, nums, m)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    private boolean isPossible(int target, int[] nums, int m) {
        int partitions = 0;

        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum > target) {
                sum = nums[i];
                partitions++;
            }

            if(partitions >= m) {
                return false;
            }
        }

        return true;
    }
}
