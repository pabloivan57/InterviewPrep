package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class PathWithGivenSequence {

    /**
     * Given a binary tree and a number sequence, find if the sequence
     * is present as a root-to-leaf path in the given tree.
     *
     * Example 1:
     *        1
     *    /       \
     * 7           9
     *         /      |
     *       2          9
     * Sequence: [1, 9, 9]Output: true Explanation: The tree has a path 1 -> 9 -> 9.
     */
    public boolean findPath(TreeNode root, int[] sequence) {
        return dfs(root, sequence, 0);
    }

    private boolean dfs(TreeNode current, int[] sequence, int index) {
        if(current == null) {
            return false;
        }

        if(index >= sequence.length || current.val != sequence[index]) {
            return false;
        }

        if(current.left == null && current.right == null
                && current.val == sequence[index]
                && index == sequence.length - 1) {
            return true;
        }

        return dfs(current.left, sequence, index + 1) || dfs(current.right, sequence, index + 1);
    }
}
