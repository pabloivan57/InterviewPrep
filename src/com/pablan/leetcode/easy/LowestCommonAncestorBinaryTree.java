package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class LowestCommonAncestorBinaryTree {

    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        recurseTree(root, p, q);
        return ans;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        // If we reached end of branch return false
        if(currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1, else 0
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion. If right recursion return true, set right = 1, else 0
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or 1
        int mid = (p.val == currentNode.val || q.val == currentNode.val) ? 1 : 0;

        // If any two of the flags left, right or mid become true
        if(mid + left + right >= 2) {
            ans = currentNode;
        }

        // Return true if any of the three bool values is True.
        return (mid + left + right > 0);
    }
}
