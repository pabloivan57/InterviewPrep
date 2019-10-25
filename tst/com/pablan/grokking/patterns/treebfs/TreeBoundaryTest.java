package com.pablan.grokking.patterns.treebfs;

import org.junit.Test;

import java.util.List;

public class TreeBoundaryTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(9);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(15);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.left = new TreeNode(6);
        List<TreeNode> result = new TreeBoundary().findBoundary(root);
        for (TreeNode node : result) {
          System.out.print(node.val + " ");
        }
    }
}
