package com.pablan.leetcode.collection.hard;

public class MedianOfTwoSortedArrays {

    /**
     * There are two sorted arrays nums1 and nums2 of size m and n respectively.
     *
     * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     *
     * You may assume nums1 and nums2 cannot be both empty.
     *
     * Example 1:
     *
     * nums1 = [1, 3]
     * nums2 = [2]
     *
     * The median is 2.0
     * Example 2:
     *
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     *
     * The median is (2 + 3)/2 = 2.5
     *
     * Pablo's notes: This is an extremely tricky problem but it does make sense after a while
     *
     * 1.- First, you know that if you merge them and pick them median you're done... but that's too slow
     * 2.- Here is where you start getting smart. Think about where you cut.... Let's look at this other problem
     * first. If you have [1 2 3 4]. How many ways you can cut it? n + 1? Why... well 3 cuts in between plus 1
     * cut at each extreme
     * [|1 2 3 4]    [1 | 2 3 4]   [1 2 | 3 4]    [1 2 3 | 4]  [1 2 3 4|]
     *
     * Now, if you start analyzing numbers odd and even you will notice the median moves every two numbers. Also
     * while going this, imagine the cut index is not the number itself but numbers in between. So
     *   [1  2] has cut indexs 0 through 2 corresponding to cuts
     * 0    1  2
     *  [1 [2]| 3]
     * 0  1   2   3
     *
     * [1 [2 | 3]  4]
     * 0  1  2   3   4
     *
     * [1   2   [3]  | 4  5]
     * 0  1   2     3    4   5
     *
     * [1   2   [3]  | [4]  5  6]
     * 0  1   2     3      4  5  6
     * .
     * .
     * .
     *  [1  2   3     [4]  |   [5]   6  7]
     * 0  1   2     3      4       5   6  7
     *  [1 2  3     [4]    |  [5]   6  7  8]
     * 0  1  2   3         4      5   6  7  8
     *
     * The median "cut" index can be found by (n + 1) / 2
     *
     * 3.- Now going back to the problem if we have two sorted arrays... imagine we merge them n + m
     * From the above we know the cut for the median will be (n + m + 1) / 2
     *
     * 4.- Since (n + m + 1) / 2 is exactly the mid point. Don't worry about even or odd now
     * What we can say is that numbers on the left come from numbers in both n and m equally
     *
     * [1, 2]
     * [3, 4]
     *
     *  [1, 2, 3, 4]
     *        |
     * 0   1  2  3  4       -> Cut should be in 2
     *
     * [1, 2] => Left side must have come from n and m... you can see that Yes, it does
     * [1 | 2]
     * [3 | 4]
     *
     * 5.- NOW this is important, if I remove a number from the left side... I will have to pick a number
     * from the right to keep proportion. Imagine cuts are as follows
     * [| 1 2]
     * [3 | 4]
     *
     * What we are saying above is that the median will be in left (for both arrays) | right... Or
     * [3] | [1 2 4] ==> Which would mean median is 3. But that was incorrect. Now let's say instead of moving left
     * I go right
     * [1 2|]
     * [| 3 4]
     *
     * From the above the only thing I want you to notice is that there is proportion and if you take elements
     * from left you have to take elements from the right.
     *
     * THIS IS KEY! because is how you find the middle point of the right array
     * If you do BINARY search on left
     * [1 2 3] and [5 6 7]
     * int low = 0, high = 2... middle = 1. Then that will mean you can pick only some from the right
     * If from the formula (n + m + 1) / 2 we know that middle will cut 3, leaving 3 elements on the side
     * And then I chose 1 already by binary search from left. That means 3 - 1 have to come from right side. Therefore
     * CUT ON RIGHT SIDE WILL BE ((n + m + 1) / 2) - middle
     *
     *
     * 5.- Now, the other condition that is immediately obvious is that the partition that belongs to the median
     * should make sure that
     *
     * 1.- Number to left of partition on first array < Number of right of partition of second array
     * AND
     * 2.- Number to left of partition on second array < Number of right of partition on first array
     *
     * If 1 is not true, that means I cut too far right on first array
     * If 2 is not true, that means I cut too far left on first array
     *
     * And with this we pick the partition
     *
     * 6.- ULTIMATELY, to make things easier. You always binary search on the smallest array so that you don't
     * deal with negative numbers when calculating the other partition. This is because second partition
     * depends on where you picked the first one ((n + m + 1) / 2) - firstPartition... which could lead to negative
     * if the array in which we do firstPartition is bigger than second one
     *
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Nums 1 we will operate on, should be the smallest array
        if(nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int size1 = nums1.length;
        int size2 = nums2.length;

        int low = 0;
        int high = nums1.length - 1;

        while(low <= high) {
            int p1 = low + (high - low) / 2;
            int p2 = (size1 + size2 + 1 / 2) - p1;

            //if p1 is 0, it means we are on the cut before the entire array. Return a super small value
            int leftP1 = p1 == 0 ? Integer.MIN_VALUE : nums1[p1 - 1];
            int rightP1 = p1 == nums2.length ? Integer.MAX_VALUE : nums1[p1];

            int leftP2 = p2 == 0 ? Integer.MIN_VALUE : nums2[p2 - 1];
            int rightP2 = p2 == nums2.length ? Integer.MAX_VALUE : nums2[p2];

            if(leftP1 <= rightP2 && leftP2 <= rightP1) {
                // I found the median
                if((size1 + size2) % 2 == 0) {
                    // If even
                    return (Math.max(leftP1, leftP2) + Math.max(rightP1, rightP2)) / 2;
                } else {
                    return Math.max(leftP1, leftP2);
                }
            } else if(leftP1 > rightP2) {
                // I cut too much to the right, go left
                high = p1 - 1;
            } else if(leftP2 > rightP1) {
                // I cut too much to the left of P1, go right
                low = p1 + 1;
            }
        }

        return -1;
    }
}
