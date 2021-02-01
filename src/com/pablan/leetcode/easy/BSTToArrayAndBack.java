package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTToArrayAndBack {

    /**
     * Write a function to convert a sorted array to a BST of minimum height. Write a function to convert a BST to a sorted array.
     */
    public TreeNode arrayToBST(int [] array) {
        return arrayToBST(array, 0, array.length - 1);
    }

    public TreeNode arrayToBST(int [] array, int start, int end) {
        if(start > end) {
            return null;
        }

        int middle = start + ((end - start) / 2);
        TreeNode current = new TreeNode(array[middle]);
        current.left = arrayToBST(array, start, middle - 1);
        current.right = arrayToBST(array, middle + 1, end);

        return current;
    }

    public Integer[] BSTToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);

        return result.toArray(new Integer[] {});
    }

    public void inOrder(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }

        inOrder(root.left, result);
        result.add(root.val);
        inOrder(root.right, result);
    }
}
