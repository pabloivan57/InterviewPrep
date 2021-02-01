package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class BSTToArrayAndBackTest {

    @Test
    public void test() {
        BSTToArrayAndBack bstToArrayAndBack = new BSTToArrayAndBack();
        System.out.print(bstToArrayAndBack.arrayToBST(new int[] {1, 2, 3, 4, 5, 6}));

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.print(bstToArrayAndBack.BSTToArray(root));
    }
}
