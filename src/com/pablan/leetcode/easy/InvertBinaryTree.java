package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class InvertBinaryTree {

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
