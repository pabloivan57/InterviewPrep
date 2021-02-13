package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.fastslow.ListNode;
import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class ConvertBinarySearchDoublyLinkedListTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        ConvertBinarySearchDoublyLinkedList convertBinarySearchDoublyLinkedList = new ConvertBinarySearchDoublyLinkedList();
        ListNode result = convertBinarySearchDoublyLinkedList.treeToDoublyList(root);
        System.out.println(result);
    }
}
