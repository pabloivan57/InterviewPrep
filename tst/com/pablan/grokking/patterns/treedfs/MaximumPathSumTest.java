package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class MaximumPathSumTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        //System.out.println("Maximum Path Sum: " + new MaximumPathSum().findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + new MaximumPathSum().findMaximumPathSum(root));

        //root = new TreeNode(-1);
        //root.left = new TreeNode(-3);
        //System.out.println("Maximum Path Sum: " + new MaximumPathSum().findMaximumPathSum(root));
    }
}
