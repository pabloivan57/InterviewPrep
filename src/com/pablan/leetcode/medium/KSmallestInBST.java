package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KSmallestInBST {

    /**
     * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
     *
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
     *
     * Example 1:
     *
     * Input: root = [3,1,4,null,2], k = 1
     *    3
     *   / \
     *  1   4
     *   \
     *    2
     * Output: 1
     * Example 2:
     *
     * Input: root = [5,3,6,2,4,null,null,1], k = 3
     *        5
     *       / \
     *      3   6
     *     / \
     *    2   4
     *   /
     *  1
     * Output: 3
     *
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        return list.get(k - 1);
    }

    public void inOrder(TreeNode node, List<Integer> list) {
        if(node == null) {
            return;
        }

        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }

    public int kSmallestOptimization(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode node = root;
        while(true) {
            while(node != null) {
                stack.add(node);
                node = node.left;
            }

            node = stack.removeLast();
            k--;
            if(k == 0) return node.val;
            node = node.right;
        }
    }
}
