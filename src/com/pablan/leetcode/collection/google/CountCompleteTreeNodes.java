package com.pablan.leetcode.collection.google;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class CountCompleteTreeNodes {

    /**
     * Given a complete binary tree, count the number of nodes.
     *
     * Note:
     *
     * Definition of a complete binary tree from Wikipedia:
     * In a complete binary tree every level, except possibly the last,
     * is completely filled, and all nodes in the last level are as far left as possible.
     * It can have between 1 and 2^h nodes inclusive at the last level h.
     *
     * Example:
     *
     * Input:
     *     1
     *    / \
     *   2   3
     *  / \  /
     * 4  5 6
     *
     * Output: 6
     *
     * Pablo's notes: The optimized algorithm does 2 things
     * 1) find the amount of nodes of level n - 1. That is because it's a binary complete tree which
     * guarantees all levels are full except the last one
     * 2) Count the nodes in the last level
     *    We can prune the search space as follows
     *    Find mid point by going through root -> left --> right --> right...
     *    if mid point is not null at level n
     *       - count from (2 ^ n) / 2 to (2 ^ n)
     *       - otherwise from (0 to 2 ^ n)
     */
    public int countNodes(TreeNode root) {
        return count(root);
    }

    private int count(TreeNode current) {
        if(current == null) {
            return 0;
        }

        return 1 + count(current.left) + count(current.right);
    }

    // Return tree depth in O(d) time.
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        int pivot;
        for(int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            }
            else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodesBinary(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int)Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root)) left = pivot + 1;
            else right = pivot - 1;
        }

        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int)Math.pow(2, d) - 1 + left;
    }
}
