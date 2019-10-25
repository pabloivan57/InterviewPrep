package com.pablan.grokking.patterns.treebfs;

import org.junit.Test;

public class LevelOrderSuccessorTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        TreeNode result = new LevelOrderSuccessor().findSuccessor(root, 12);
        if (result != null)
            System.out.println(result.val + " ");
        result = new LevelOrderSuccessor().findSuccessor(root, 9);
        if (result != null)
        System.out.println(result.val + " ");
    }
}
