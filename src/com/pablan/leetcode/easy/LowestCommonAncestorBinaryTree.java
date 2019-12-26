package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class LowestCommonAncestorBinaryTree {

    private TreeNode ans = null;

    /**
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes
     *  p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     *                 6
     *             /     \
     *            2       8
     *           / \     / \
     *          0   4   7   9
     *            /  \
     *           3    5
     *
     * Example 1:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     * Example 2:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * Output: 2
     * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
     *
     */
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
