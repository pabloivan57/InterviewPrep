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
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(one)); // should be 6

        TreeNode twoAlt = new TreeNode(2);
        TreeNode oneNegative = new TreeNode(-1);

        twoAlt.left = oneNegative;
        binaryTreeMaximumPathSum = new BinaryTreeMaximumPathSum();
        System.out.println(binaryTreeMaximumPathSum.maxPathSum(twoAlt)); // should be 2
    }
}
