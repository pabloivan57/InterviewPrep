package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class MaximumPathSum {

    int globalMaximum;

    /**
     *  Find the path with the maximum sum in a given binary tree.
     *  Write a function that returns the maximum sum.
     *
     * A path can be defined as a sequence of nodes between any two nodes and doesn’t
     * necessarily pass through the root. The path must contain at least one node.
     *
     * Pablo's notes: When you do a normal dfs, you can go left, right center.
     * If you visit nodes in that order you will start having "local" paths
     *
     */
    public int findMaximumPathSum(TreeNode root) {
        globalMaximum  = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return globalMaximum;
    }

    public int findMaximumPathSumRecursive(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int leftBranch = findMaximumPathSumRecursive(root.left);
        int rightBranch = findMaximumPathSumRecursive(root.right);

        leftBranch = Math.max(leftBranch, 0);
        rightBranch = Math.max(rightBranch, 0);

        int localMaximum = leftBranch + rightBranch + root.val;
        globalMaximum = Math.max(globalMaximum, localMaximum);

        return Math.max(leftBranch, rightBranch) + root.val;
    }
}
