package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class KSmallestInBST {

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
