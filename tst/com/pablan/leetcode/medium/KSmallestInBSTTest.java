package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class KSmallestInBSTTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        five.left = three;
        five.right = six;
        three.left = two;
        three.right = four;
        two.left = one;

        KSmallestInBST kSmallestInBST = new KSmallestInBST();
        System.out.println(kSmallestInBST.kSmallestOptimization(five, 3));
    }
}
