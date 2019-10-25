package com.pablan.grokking.patterns.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean rightOrder = true;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new LinkedList<>();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if(rightOrder) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
            rightOrder = !rightOrder;
        }

        return result;
    }
}
