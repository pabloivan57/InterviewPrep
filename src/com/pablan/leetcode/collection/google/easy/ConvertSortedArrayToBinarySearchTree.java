package com.pablan.leetcode.collection.google.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth
     * of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursiveBST(nums, 0, nums.length - 1);
    }

    private TreeNode recursiveBST(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }

        int middle = left + ((right - left) / 2);
        TreeNode node = new TreeNode(nums[middle]);

        node.left = recursiveBST(nums, left, middle - 1);
        node.right = recursiveBST(nums, middle + 1, right);

        return node;
    }
}
