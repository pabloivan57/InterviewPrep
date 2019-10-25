package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return inOrder(root, null, null);
    }

    public boolean inOrder(TreeNode current, Integer max, Integer min) {
        if(current == null) return true;

        if((max != null && current.val >= max)
                || (min  != null && current.val <= min)) {
            return false;
        }

        boolean left = inOrder(current.left, current.val, min);
        boolean right = inOrder(current.right, max, current.val);

        return left && right;
    }
}
