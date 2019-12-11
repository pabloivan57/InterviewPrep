package com.pablan.leetcode.hard;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import com.pablan.leetcode.medium.BinaryTreeMaximumPathSum;
import org.junit.Test;

public class BinaryTreeMaximumPathSumTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.left = two;
        one.right = three;

        BinaryTreeMaximumPathSum binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(one));
    }
}
