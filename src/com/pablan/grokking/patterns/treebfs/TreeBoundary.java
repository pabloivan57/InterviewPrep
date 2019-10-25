package com.pablan.grokking.patterns.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBoundary {

    public List<TreeNode> findBoundary(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();

        if(root == null) {
            return  result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode node;

            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();

                if(i == 0) {
                    result.add(node);
                }
                else if(i == levelSize - 1) {
                    result.add(node);
                }
                else if(node.left == null && node.right == null) {
                    //we should add leaves
                    result.add(node);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}
