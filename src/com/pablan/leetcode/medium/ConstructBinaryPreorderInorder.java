package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class ConstructBinaryPreorderInorder {

    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     *
     * Note:
     * You may assume that duplicates do not exist in the tree.
     *
     * For example, given
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     * Return the following binary tree:
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     *
     * Pablo's notes: The two of them together have an interesting property
     * the value that you pick in preorder divides the inOrder in half,
     * for example let's say you have 3 from preorder (a.k.a root)
     * that corresponds to index 1 in the inorder array and divides the tree in two parts
     *             3
     *       9        15,20,7 -> to be arranged
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

    }
}
