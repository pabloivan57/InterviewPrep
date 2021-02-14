package com.pablan.leetcode.medium;

public class EqualSubsetSumPartition {

    /**
     * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets
     * such that the sum of elements in both subsets is equal.
     *
     * Note:
     *
     * Each of the array element will not exceed 100.
     * The array size will not exceed 200.
     *
     *
     * Example 1:
     *
     * Input: [1, 5, 11, 5]
     *
     * Output: true
     *
     * Explanation: The array can be partitioned as [1, 5, 5] and [11].
     *
     *
     * Example 2:
     *
     * Input: [1, 2, 3, 5]
     *
     * Output: false
     *
     * Explanation: The array cannot be partitioned into equal sum subsets.
     *
     * Pablo's notes: So how do you get two even parts of something? You divide it by 2,
     * this problem is asking exactly that. Can we find a subset that equals the whole things divided by 2?
     * And that is a very well know algorithm, a number in the set CAN or CANNOT be part of the solution. Dp exercise
     *
     * Also, note something. Why is it called even number? because it can be divided by 2.. therefore
     * the total of nums MUST be an even number otherwise there is no points in trying this solution. Of course that is
     * because we use integers
     */
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        //return canPartition(totalSum / 2, 0, nums);
        return canPartitionBottomUp(totalSum / 2, nums);

    }

    private boolean canPartition(int target, int index, int[] nums)  {
        if(index >= nums.length) {
            return false;
        }

        if(target == 0) {
            return true;
        }

        // case 1, I pick the number
        boolean case1 = false;
        if(nums[index] <= target) {
            case1 = canPartition(target - nums[index], index + 1, nums);
        }

        // case 2, I skip the number
        boolean case2 = canPartition(target, index + 1, nums);

        return case1 || case2;
    }

    private boolean canPartitionBottomUp(int target, int[] nums) {
        boolean[][] dp = new boolean[nums.length][target + 1];

        // calculate item 0 with capacity i
        for(int i = 0; i < target; i++) {
            if(nums[0] == i) {
                dp[0][i] = true;
            }
        }

        // now with 1 item with capacity 0 ... j
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j <= target; j++) {
                // case 1 I have enough capacity
                boolean case1 = false;
                if(nums[i] <= j) {
                    case1 = dp[i - 1][j - nums[i]];
                }

                // case 2 I skip
                boolean case2 = dp[i - 1][j];

                dp[i][j] = case1 || case2;
            }
        }

        return dp[nums.length - 1][target];
    }
}
