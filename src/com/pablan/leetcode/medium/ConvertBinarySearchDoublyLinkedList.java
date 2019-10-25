package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class ConvertBinarySearchDoublyLinkedList {

    TreeNode first = null;
    TreeNode last = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if(root == null) return null;

        inorder(root);

        last.right = first;
        first.left = last;

        return first;
    }

    // InOder: left, root, right
    private void inorder(TreeNode node) {
        if(node == null) return;

        //left
        inorder(node.left);
        //node
        if(last != null) {
            // link the previous node (last)
            // with the current node (node)
            last.right = node;
            node.left = last;
        } else {
            // keep the smallest node
            // to close DDL later on
            first = node;
        }

        last = node;

        //right
        inorder(node.right);
    }
}
