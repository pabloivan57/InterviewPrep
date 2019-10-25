package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

import java.util.List;

public class BinaryTreeLevelOrderTraversalTest {

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

        BinaryTreeLevelOrderTraversal binaryTreeLevelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> result = binaryTreeLevelOrderTraversal.levelOrder(three);

        for(List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
