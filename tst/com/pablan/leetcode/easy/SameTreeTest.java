package com.pablan.leetcode.easy;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class SameTreeTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        one.left = two;
        one.right = three;

        TreeNode onePrima = new TreeNode(1);
        TreeNode twoPrima = new TreeNode(2);
        TreeNode threePrima = new TreeNode(3);

        onePrima.left = twoPrima;
        onePrima.right = threePrima;

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(one, onePrima));
    }
}
