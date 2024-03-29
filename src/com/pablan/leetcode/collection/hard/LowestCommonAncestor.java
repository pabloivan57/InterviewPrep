package com.pablan.leetcode.collection.hard;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class LowestCommonAncestor {

    TreeNode ans;

    /**
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     *
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both
     * p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
     *
     * Example 1:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
     * Output: 3
     * Explanation: The LCA of nodes 5 and 1 is 3.
     * Example 2:
     *
     * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
     * Output: 5
     * Explanation: The LCA of nodes 5 and 4 is 5,
     * since a node can be a descendant of itself according to the LCA definition.
     *
     * Pablo's notes: The idea is to count when I find p or q and send back that 1 all the way back to the top
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, p , q);
        return ans;
    }

    private int traverse(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return 0;
        }

        int left = traverse(root.left, p, q);
        int right = traverse(root.right, p, q);

        int middle = (root.val == p.val || root.val == q.val) ? 1 : 0;
        int total = left + right + middle;

        if(total >= 2) {
            // found lowest common ancestor
            ans = root;
        }

        return total > 0 ? 1 : 0;
    }
}
