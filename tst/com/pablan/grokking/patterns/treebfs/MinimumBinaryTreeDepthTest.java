package com.pablan.grokking.patterns.treebfs;

import org.junit.Test;

public class MinimumBinaryTreeDepthTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree Minimum Depth: " + new MinimumBinaryTreeDepth().findDepth(root));
        root.left.left = new TreeNode(9);
        root.right.left.left = new TreeNode(11);
        System.out.println("Tree Minimum Depth: " + new MinimumBinaryTreeDepth().findDepth(root));
    }
}
