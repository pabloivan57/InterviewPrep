package com.pablan.leetcode.collection.google.hard;

public class DivideChocolate {

    /**
     * You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.
     *
     * You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces
     * using K cuts, each piece consists of some consecutive chunks.
     *
     * Being generous, you will eat the piece with the minimum total sweetness and give the other pieces
     * to your friends.
     *
     * Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
     *
     * Example 1:
     *
     * Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
     * Output: 6
     * Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
     * Example 2:
     *
     * Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
     * Output: 1
     * Explanation: There is only one way to cut the bar into 9 pieces.
     * Example 3:
     *
     * Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
     * Output: 5
     * Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
     *
     * Pablo's notes:
     *
     * This problem is exactly the same as SplitArrayLargestSum, the difference is that opposed to SplitArrayLargestSum
     * this problem asks you to maximize the minimum. To understand look at the example below
     *
     * [1, 2, 3, 4, 5, 6, 7, 8, 9]. You have 9 pieces. Let's say you have 9 friends. Not possible to split in 10 pieces
     * including you. Now, let's say you have 8 friends, ok you can but the minimum sweetness is the minimum piece
     * in other words 1, now let's say you have 0 friends then the minimum sweetness is the whole chunk
     *
     * So, you established two boundaries the minimum sweetness piece and the whole bar
     *
     * BY MAXIMIZING THE MINIMUM this means... I know the minimum piece I can get is 1 given 8 friends... but let's say
     * I have 7 friends. Can I get 2 sweetness? How about 3 sweetness? Basically the algorithm binary searches those
     *
     * Another subtle difference is that because you're maximizing the minimum when you select pieces you will include
     * those in the array until the value is more than target. Because you are finding with at least sweetness as opposed
     * to at most sweetness. Basically instead to sum = nums[i] you do sum = 0 to represent that nums[i] was part of the
     * last chunk
     *
     */
    public int maximizeSweetness(int[] sweetness, int K) {
        int left = 0;
        int right = 0;

        // Calculate boundaries
        for(int i = 0; i < sweetness.length; i++) {
            left = Math.min(left, sweetness[i]);
            right += sweetness[i];
        }

        while(left < right) {
            int mid = left + ((right - left) / 2);
            // basically we are saying. Can I split into K + 1 piece of M sweetness?
            // If yes, try a bigger number, otherwise a lower
            // Imagine you want 5 pieces of 23 swetnees of the bar. Impossible you can have at most 2
            // So we attempt to look for a smaller number
            if(piecesOfAtLeastNSweetness(mid, sweetness) < K + 1) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // This is just helpful to understand, makes things easier to understand
    public int piecesOfAtLeastNSweetness(int target, int[] sweetness) {
        int pieces = 0;

        int sum = 0;
        for(int i = 0; i < sweetness.length; i++) {
            sum = sum + sweetness[i];
            if(sum > target) {
                pieces++;
                sum = 0;
            }
        }

        return pieces;
    }
}
