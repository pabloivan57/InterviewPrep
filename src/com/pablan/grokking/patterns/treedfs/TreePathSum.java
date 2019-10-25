package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

public class TreePathSum {

    // S: 10
    // Output: true
    // Explaination: The path with sum '10' is highlighted
    public boolean hasPath(TreeNode root, int sum) {
        // this means we are below a leaf node
        if (root == null)  {
            return false;
        }

        // Since we are substracting everytime we move in the tree
        // the moment root.val has a value equal to sum, we know there
        // is a path in the tree
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }

        // recursively call for each side of the branch
        return hasPath(root.left, sum - root.val)
                || hasPath(root.right, sum - root.val);
    }
}
