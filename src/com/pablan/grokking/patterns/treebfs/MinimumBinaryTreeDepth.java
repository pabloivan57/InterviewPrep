package com.pablan.grokking.patterns.treebfs;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumBinaryTreeDepth {

    public int findDepth(TreeNode root) {

        int currentLevel = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            TreeNode node;

            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();

                // If it's leave
                if(node.left == null && node.right == null) {
                    return currentLevel;
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return currentLevel;
    }
}
