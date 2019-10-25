package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    /**
     * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
     *
     * For example:
     * Given binary tree [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * return its level order traversal as:
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int levelSize  = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                level.add(current.val);

                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
            result.add(level);
        }

        return result;
    }
}
