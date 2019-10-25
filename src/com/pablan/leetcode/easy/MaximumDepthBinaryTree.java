package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class MaximumDepthBinaryTree {

    /**
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     * Example:
     *
     * Given binary tree [3,9,20,null,null,15,7]
     */
    public int maxDepth(TreeNode root) {
        return preOrder(root, 0);
    }

    public int preOrder(TreeNode current, int level)  {
        if(current == null) {
            return level;
        }

        int leftHeight = preOrder(current.left, level + 1);
        int rightHeight = preOrder(current.right, level + 1);

        return Math.max(leftHeight, rightHeight);
    }
}
