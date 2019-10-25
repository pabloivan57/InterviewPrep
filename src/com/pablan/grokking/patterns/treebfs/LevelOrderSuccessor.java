package com.pablan.grokking.patterns.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {

    public TreeNode findSuccessor(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node;
            node = queue.poll();

            if(node.left != null) {
                queue.offer(node.left);
            }

            if(node.right != null) {
                queue.offer(node.right);
            }

            if(node.val == key) {
                break;
            }
        }

        return queue.peek();
    }
}
