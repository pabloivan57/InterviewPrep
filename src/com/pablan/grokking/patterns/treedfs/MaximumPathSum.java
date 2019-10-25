package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class MaximumPathSum {

    int globalMaximum;

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
