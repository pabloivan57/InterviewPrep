package com.pablan.leetcode.facebook;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class SerializeBinaryTree {

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
