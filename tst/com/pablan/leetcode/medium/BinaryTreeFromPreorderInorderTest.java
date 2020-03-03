package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class BinaryTreeFromPreorderInorderTest {

    @Test
    public void test() {
        BinaryTreeFromPreorderInorder binaryTreeFromPreorderInorder = new BinaryTreeFromPreorderInorder();

        TreeNode root = binaryTreeFromPreorderInorder.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
        System.out.println(root);
    }
}
