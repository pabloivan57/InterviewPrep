package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class SymmetricTreeTest {

    @Test
    public void test() {
        SymmetricTree symmetricTree = new SymmetricTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(0);

        root.left.left.left = new TreeNode(3);
        root.left.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(3);

        System.out.print(symmetricTree.isMirror(root, root));
    }
}
