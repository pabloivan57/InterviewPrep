package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class SumOfPathNumbers {

    public int findSumOfPathNumbers(TreeNode root) {
        return findSumOfPathNumbers(root, 0);
    }

    public int findSumOfPathNumbers(TreeNode node, int sum) {
        if(node == null) {
            return 0;
        }

        int newSum = (sum * 10) + node.val;

        if(node.left == null && node.right == null) {
            return newSum;
        }

        return findSumOfPathNumbers(node.left, newSum) + findSumOfPathNumbers(node.right, newSum);
    }
}
