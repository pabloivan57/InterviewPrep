package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int maxPath = Integer.MIN_VALUE;

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
