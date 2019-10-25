package com.pablan.grokking.patterns.treebfs;

import org.junit.Test;

import java.util.List;

public class ZigZagTraversalTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = new ZigZagTraversal().traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
