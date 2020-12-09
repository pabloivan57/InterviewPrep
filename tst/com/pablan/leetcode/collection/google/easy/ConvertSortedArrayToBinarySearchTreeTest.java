package com.pablan.leetcode.collection.google.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTreeTest {

    @Test
    public void test() {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        TreeNode root = convertSortedArrayToBinarySearchTree.sortedArrayToBST(new int[] {-10,-3,0,5,9});
        System.out.println(root);
    }
}
