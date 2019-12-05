package com.pablan.leetcode.facebook;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SerializeBinaryTree {

    /**
     * Serialization is the process of converting a data structure or object into a sequence of bits
     * so that it can be stored in a file or memory buffer,
     * or transmitted across a network connection link
     * to be reconstructed later in the same or another computer environment.
     *
     * Design an algorithm to serialize and deserialize a binary tree.
     * There is no restriction on how your serialization/deserialization algorithm should work.
     * You just need to ensure that a binary tree can be serialized to a string and this string
     * can be deserialized to the original tree structure.
     *
     * Example:
     *
     * You may serialize the following tree:
     *
     *     1
     *    / \
     *   2   3
     *      / \
     *     4   5
     *
     * as "[1,2,3,null,null,4,5]"
     *
     */
    public String serialize(TreeNode root) {
        if(root == null) {
            return "null";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder expression = new StringBuilder();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current == null) {
                    expression.append("#,");
                    continue;
                }
                expression.append(current.val).append(",");
                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        return expression.toString();
    }

    public TreeNode deserialize(String expression) {
        String[] nodes = expression.split(",");
        int pointer = 0;
        if(nodes[0].equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(nodes[pointer++]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if(!nodes[pointer].equals("#")) {
                    current.left = new TreeNode(Integer.valueOf(nodes[pointer]));
                    queue.offer(current.left);
                }
                pointer++;

                if(!nodes[pointer].equals("#")) {
                    current.right = new TreeNode(Integer.valueOf(nodes[pointer]));
                    queue.offer(current.right);
                }
                pointer++;
            }
        }

        return root;
    }
}
