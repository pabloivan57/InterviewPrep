package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import com.sun.source.tree.Tree;

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
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * return its depth = 3.
     */
    public int maxDepth(TreeNode root) {
        return inOrder(root);
    }

    public int inOrder(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int left = inOrder(node.left);
        int right = inOrder(node.right);

        return Math.max(left, right) + 1;
    }
}
