package com.pablan.grokking.patterns.treebfs;

import org.junit.Test;

import java.util.List;

public class AverageOfLevelTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = new AverageOfLevel().findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
