package com.pablan.leetcode.collection.hard;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class LowestCommonAncestorTest {

    @Test
    public void test() {
        TreeNode three = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        three.left = five;
        three.right = one;
        five.left = six;
        five.right = two;
        two.left = seven;
        two.right = four;
        one.left = zero;
        one.right = eight;

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(three, five, one).val); // should be 3

        six = new TreeNode(6);
        six.left = new TreeNode(2);
        six.right = new TreeNode(8);
        six.left.left = new TreeNode(0);
        six.left.right = new TreeNode(4);
        six.left.right.left = new TreeNode(3);
        six.left.right.right = new TreeNode(5);

        six.right = new TreeNode(8);
        six.right.left = new TreeNode(7);
        six.right.right = new TreeNode(9);

        lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(six, new TreeNode(2), new TreeNode(5)).val); // should be 2
    }
}
