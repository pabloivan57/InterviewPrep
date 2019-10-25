package com.pablan.grokking.patterns.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevel {

    public List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            TreeNode node;

            for(int i = 0; i < levelSize; i++) {
                node = queue.poll();
                levelSum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(levelSum / levelSize);
        }

        return result;
    }
}
