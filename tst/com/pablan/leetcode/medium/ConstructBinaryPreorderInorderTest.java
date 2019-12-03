package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class ConstructBinaryPreorderInorderTest {

    @Test
    public void test() {
        ConstructBinaryPreorderInorder constructBinaryPreorderInorder = new ConstructBinaryPreorderInorder();

        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        TreeNode root = constructBinaryPreorderInorder.buildTree(preorder, inorder);
        System.out.println(root);
    }
}
