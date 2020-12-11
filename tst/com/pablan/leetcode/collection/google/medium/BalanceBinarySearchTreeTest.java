package com.pablan.leetcode.collection.google.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class BalanceBinarySearchTreeTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        BalanceBinarySearchTree balance = new BalanceBinarySearchTree();
        TreeNode balancedRoot = balance.balanceBST(root);
        System.out.println(balancedRoot);
    }
}
