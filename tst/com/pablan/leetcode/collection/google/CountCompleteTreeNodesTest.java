package com.pablan.leetcode.collection.google;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class CountCompleteTreeNodesTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;

        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        System.out.println(countCompleteTreeNodes.countNodes(one)); // Should be 6
    }
}
