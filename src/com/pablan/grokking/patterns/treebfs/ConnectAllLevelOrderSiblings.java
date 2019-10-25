package com.pablan.grokking.patterns.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {

    public void connect(TreeNode root) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode previousNode = null;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(previousNode != null) {
                    previousNode.next = node;
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }

                previousNode = node;
            }
        }

        return;
    }
}
