package com.pablan.leetcode.facebook;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class SerializeBinaryTreeTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;

        SerializeBinaryTree serializeBinaryTree = new SerializeBinaryTree();
        String expression = serializeBinaryTree.serialize(one);
        System.out.println(expression);
        TreeNode root = serializeBinaryTree.deserialize(expression);
        System.out.println(root);
    }
}
