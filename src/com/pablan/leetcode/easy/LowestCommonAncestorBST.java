package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class LowestCommonAncestorBST {

    /**
     *
     * The property of BST is what makes this question easy, otherwise  it would be medium difficulty with just
     * a Binary Tree
     *
     * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
     *
     * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
     *
     * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
     *
     * Example 1:
     *
     * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * Output: 6
     * Explanation: The LCA of nodes 2 and 8 is 6.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int rootVal = root.val;
        int pVal = p.val;
        int qVal = q.val;

        if(pVal < rootVal && qVal < rootVal) {
            // Both nodes are on the left side of the tree
            return lowestCommonAncestor(root.left, p, q);
        } else if(pVal > rootVal && qVal > rootVal) {
            // Both nodes are on the right side of the tree
            return lowestCommonAncestor(root.right, p, q);
        }

        // If none of the conditions are met, we found a break point. Return the root
        // Notice how this uses the BST definition, left values are less than root and right
        // values are more than root
        return root;
    }
}
