package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class InOrderSuccessorBSTTest {

    @Test
    public void test() {
        InOrderSuccessorBST inOrderSuccessorBST = new InOrderSuccessorBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(inOrderSuccessorBST.inorderSuccessor(root, new TreeNode(1)));
    }
}
