package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class MaximumDepthBinaryTreeTest {

    @Test
    public void test() {
        TreeNode three = new TreeNode(3);
        TreeNode nine = new TreeNode(9);
        TreeNode twenty = new TreeNode(20);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);

        three.left = nine;
        three.right = twenty;
        twenty.left = fifteen;
        twenty.right = seven;

        MaximumDepthBinaryTree maximumDepthBinaryTree = new MaximumDepthBinaryTree();
        System.out.println(maximumDepthBinaryTree.maxDepth(three));
    }
}
