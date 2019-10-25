package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class TreePathSumTest {
    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + new TreePathSum().hasPath(root, 23));
    }
}
