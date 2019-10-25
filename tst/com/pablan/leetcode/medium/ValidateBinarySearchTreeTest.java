package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void test() {
        ValidateBinarySearchTree validateBinarySearchTree = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(Integer.MAX_VALUE);
        System.out.println(validateBinarySearchTree.isValidBST(root));
    }
}
