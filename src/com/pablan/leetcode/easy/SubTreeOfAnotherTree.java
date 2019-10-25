package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class SubTreeOfAnotherTree {

    /**
     * Given two non-empty binary trees s and t, check whether tree t
     * has exactly the same structure and node values with a subtree of s.
     * A subtree of s is a tree consists of a node in s and all of this node's descendants.
     * The tree s could also be considered as a subtree of itself.
     *
     * Example 1:
     * Given tree s:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * Given tree t:
     *    4
     *   / \
     *  1   2
     * Return true, because t has the same structure and node values with a subtree of s.
     *
     * Approach 1: create a string using ALL elements of the tree
     *  - left  null == lnull
     *  - right null == rnull
     *
     *
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);

        return tree1.indexOf(tree2) >= 0;
    }

    private String preorder(TreeNode t, boolean left) {
        if(t == null) {
            if(left) {
                return "lnull";
            } else {
                return "rnull";
            }
        }

        return "#"+t.val+ " "+ preorder(t.left, true) + " " +preorder(t.right, false);
    }

    /**
     * For approach two we just traverse 1 node at a time and then
     * we compare the node.left  as it is root against t  and node.right against t
     *
     * Is like a cartesian product
     */
    public boolean isSubtree2(TreeNode s, TreeNode t) {
        return traverse(s, t);
    }

    public boolean equals(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }

        if(s == null || t == null) {
            return false;
        }

        return s.val == t.val && equals(s.left, t.left) && equals(s.right, t.right);
    }

    public boolean traverse(TreeNode s, TreeNode t) {
        return s != null && (equals(s, t) || traverse(s.left, t) || traverse(s.right, t));
    }
}
