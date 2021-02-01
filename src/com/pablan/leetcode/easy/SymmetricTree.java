package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class SymmetricTree {

    /**
     * Write a program to check if the given binary tree is symmetric tree or not.
     * A symmetric tree is defined as a tree which is mirror image of itself about the root node.
     * For example, following tree is a symmetric tree.
     *
     *                                     3
     *                              /                 \
     *                          1                        1
     *                     /        \                  /    \
     *                 0             2              2         0
     *               /                 \           /            \
     *            3                      4       4               3
     */
    public boolean isMirror(TreeNode n1, TreeNode n2) {
        if(n1 == null && n2 == null) {
            return true;
        }

        if(n1 == null || n2 == null) {
            return false;
        }

        boolean isLeft = isMirror(n1.left, n2.right);
        boolean isRight = isMirror(n1.right, n2.left);
        boolean isCenter = n1.val == n2.val;

        return isLeft && isRight && isCenter;
    }
}
