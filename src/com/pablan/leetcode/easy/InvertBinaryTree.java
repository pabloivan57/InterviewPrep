package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class InvertBinaryTree {

    /**
     * Invert a binary tree.
     *
     * Example:
     *
     * Input:
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * Output:
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     */
    public TreeNode invertBinaryTree(TreeNode root) {
        preOrder(root);
        return root;
    }

    private void preOrder(TreeNode current) {
        if(current == null) return;

        preOrder(current.left);
        preOrder(current.right);

        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
    }
}
