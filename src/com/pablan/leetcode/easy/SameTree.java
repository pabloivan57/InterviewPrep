package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class SameTree {

    /**
     * Given two binary trees, write a function to check if they are the same or not.
     *
     * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
     *
     * Example 1:
     *
     * Input:     1         1
     *           / \       / \
     *          2   3     2   3
     *
     *         [1,2,3],   [1,2,3]
     *
     * Output: true
     *
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p == null && q == null) {
           return true;
       }

       if(p == null || q == null || p.val != q.val) {
           return false;
       }

       return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
