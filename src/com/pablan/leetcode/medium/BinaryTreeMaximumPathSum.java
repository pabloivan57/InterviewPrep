package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int maxPath = Integer.MIN_VALUE;

    /**
     *  Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     *
     */
    public int maxPathSum(TreeNode root) {
        calculatePath(root);

        return maxPath;
    }

    private int calculatePath(TreeNode currentNode) {
        if(currentNode == null) {
            return 0;
        }

        int leftTreeHeight = Math.max(calculatePath(currentNode.left), 0);
        int rightTreeHeight = Math.max(calculatePath(currentNode.right), 0);

        int path = leftTreeHeight + rightTreeHeight + currentNode.val;

        maxPath = Math.max(maxPath, path);

        return Math.max(leftTreeHeight, rightTreeHeight) + currentNode.val;
    }
}
