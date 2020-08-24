package com.pablan.leetcode.collection.google.medium;

public class MaximumPointsFromCards {
    /**
     * There are several cards arranged in a row, and each card has an associated number of points
     * The points are given in the integer array cardPoints.
     *
     * In one step, you can take one card from the beginning or from the end of the row.
     * You have to take exactly k cards.
     *
     * Your score is the sum of the points of the cards you have taken.
     *
     * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
     *
     * Example 1:
     *
     * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
     * Output: 12
     * Explanation: After the first step, your score will always be 1.
     * However, choosing the rightmost card first will maximize your total score.
     * The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
     * Example 2:
     *
     * Input: cardPoints = [2,2,2], k = 2
     * Output: 4
     * Explanation: Regardless of which two cards you take, your score will always be 4.
     *
     * Example 3:
     *
     * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
     * Output: 55
     * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
     * Example 4:
     *
     * Input: cardPoints = [1,1000,1], k = 1
     * Output: 1
     * Explanation: You cannot take the card in the middle. Your best score is 1.
     *
     * Example 5:
     *
     * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
     * Output: 202
     *
     * Pablo's notes: The examples above are lame but what this is really telling you is that
     * you can pick up to 3 cards, left or right. One at a time, so you can do
     * k = 3, pick left --> k = 2, pick right --> k = 1, pick right k = 0
     *
     * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/discuss/597825/Simple-Clean-Intuitive-Explanation-with-Visualization
     * The way to understand this problem is as follows, you have an array of n elements.
     *
     * k = 3
     * If you pick 1 from the left, then you have to pick 2 from the right
     * If you pick 2 from the left, then you have to pick 1 from the right
     *
     * So you simply go to all the alternatives above, a way to do that is to have two
     * cummulative arrays
     * sumLeft[]
     * sumright[]
     *
     * Then you can represent pick up 1 from left, 2 from right as:
     *
     * for(int i = 1; i < k; i++)
     * {
     *     sumLeft[i] + sumRight[totalLength - k + i]
     * }
     */
    public int maxScore(int[] cardPoints, int k) {
        // precompute cummulatives
        int[] sumLeft = new int[cardPoints.length + 1];
        for(int i = 0; i < cardPoints.length; i++) {
            sumLeft[i + 1] = sumLeft[i] + cardPoints[i];
        }

        int[] sumRight = new int[cardPoints.length + 1];
        for(int i = cardPoints.length - 1; i >= 0; i--) {
            sumRight[i] = sumRight[i + 1] + cardPoints[i];
        }

        // compute max
        int maxScore = 0;
        for(int i = 0; i < k; i++) {
            maxScore = Math.max(maxScore, sumLeft[i] + sumRight[cardPoints.length - k + i]);
        }
        return maxScore;
    }
}
