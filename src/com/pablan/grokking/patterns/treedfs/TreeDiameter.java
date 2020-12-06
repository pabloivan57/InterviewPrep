package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class TreeDiameter {

    /**
     *  Given a binary tree, find the length of its diameter.
     *  The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
     *  The diameter of a tree may or may not pass through the root.
     *
     *  Note: You can always assume that there are at least two leaf nodes in the given tree.
     *
     */
    private int maxDiameter;

    public int findDiameter(TreeNode root) {
        maxDiameter = Integer.MIN_VALUE;
        dfs(root);
        return maxDiameter;
    }

    private int dfs(TreeNode current) {
        if(current == null) {
            return 0;
        }

        int left = dfs(current.left);
        int right = dfs(current.right);

        int localDiameter = left + right + 1;
        if(localDiameter > maxDiameter) {
            maxDiameter = localDiameter;
        }

        return Math.max(left, right) + 1;
    }
}
