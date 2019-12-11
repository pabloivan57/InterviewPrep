package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class BinaryTreeMaximumPathSum {

    private int maxPath = Integer.MIN_VALUE;

    /**
     *  Given a non-empty binary tree, find the maximum path sum.
     *
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     *
     *        1
     *       / \
     *      2   3
     *
     * Output: 6
     * Example 2:
     *
     * Input: [-10,9,20,null,null,15,7]
     *
     *    -10
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *
     * Output: 42
     *
     * Pablo's notes: There is a special case for the following tree
     *
     *    2
     *   /
     * -1
     *
     * Here we only want to use the root, but if we sum left path to current value
     * we won't get the right values. To overcome this we use a greedy approach
     * if the left branch is negative then it doesn't make sense to add it current
     * (even if current is negative too) so then we return 0
     */
    public int maxPathSum(TreeNode root) {
        calculatePath(root);

        return maxPath;
    }

    private int calculatePath(TreeNode currentNode) {
        if(currentNode == null) {
            return 0;
        }

        int left = Math.max(calculatePath(currentNode.left), 0);
        int right = Math.max(calculatePath(currentNode.right), 0);

        int localPath = left + right + currentNode.val;

        maxPath = Math.max(maxPath, localPath);

        return Math.max(left, right) + currentNode.val;
    }
}
