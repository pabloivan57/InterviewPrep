package com.pablan.leetcode.collection.google.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {

    /**
     *  Given a binary search tree, return a balanced binary search tree with the same node values.
     *
     *  A binary search tree is balanced if and only if the depth of the
     *  two subtrees of every node never differ by more than 1.
     *
     *  If there is more than one answer, return any of them.
     *
     *  Example 1:
     *
     *  Input: root = [1,null,2,null,3,null,4,null,null]
     *  Output: [2,1,3,null,null,null,4]
     *  Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
     *
     *  Pablo's notes: Rebalancing a Tree is a two step process. First
     *  traverse the tree in sorted order. Then with that sorted list, create a BST from scratch.
     *  If you have a sorted list, then creating a tree is the same as a binary search
     *
     *  1.- Take middle of list
     *  2.- Middle of list is the root of tree
     *  3.- Then iteratively do the same with the left part
     *  4.- Then iteratively do the same with the right part
     *  5.- Return root
     */
    List<TreeNode> sortedTreeNodes;

    public TreeNode balanceBST(TreeNode root) {
        sortedTreeNodes = new ArrayList<>();
        inOrder(root);
        return recursiveBST(sortedTreeNodes, 0, sortedTreeNodes.size() - 1);
    }

    private void inOrder(TreeNode root) {
        if(root == null)
            return;

        inOrder(root.left);
        sortedTreeNodes.add(root);
        inOrder(root.right);
    }

    private TreeNode recursiveBST(List<TreeNode> sortedNodes, int start, int end) {
        if(start > end) {
            return null;
        }

        int middle = (start + (end - start)) / 2;
        TreeNode current = sortedNodes.get(middle);

        current.left = recursiveBST(sortedNodes, start, middle - 1);
        current.right = recursiveBST(sortedNodes, middle + 1, end);

        return current;
    }
}
