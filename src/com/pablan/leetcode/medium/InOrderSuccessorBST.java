package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class InOrderSuccessorBST {

    /**
     *  Pablo's notes: The idea here is that if the node you're looking for has a right branch
     *  then the next value in BST will be the farthest left from the right.
     *
     *  So, you taken care of that scenario... now if it doesn't have a right, then the part of course
     *  will be the parent of the node they are looking.
     *
     *  Now, here is a tricky scenario because you don't want to go inorder the whole tree, so you
     *  take advantage of BST and go left, right depending on the value
     *
     *  Now imagine this sceanrio
     *
     *           5
     *       1       6
     *    0    3                    -> Imagine I'm looking for 3
     *       2
     *
     *    In order will go 5 -> 1 -> 0. And the backtrack to 1 -> 3... to have visited 3 it means I already
     *    went the whole left branch... therefore the next should be 1? Nope, because I came from 1 it's already
     *    visited, therefore you go to the part. Or, 5... that's the next inOrder
     *
     *    In other words, you only keep successor when going to left, now when going to right
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode n) {
        //Case 1 : Right Subtree is not empty
        if(n.right != null) {
            n = n.right;

            //loop down to find the leftmost leaf
            while(n != null) {
                n = n.left;
            }

            return n;
        }

        // Case 2: Right tree empty. Now Start from root and search for successor down the tree
        TreeNode successor = null;
        while(root != null) {
            if(n.val < root.val) {
                successor = n;
                root = root.left;
            } else if(n.val > root.val) {
                root = root.right;
            } else if(n.val == root.val) {
                break;
            }
        }

        return successor;

    }
}
