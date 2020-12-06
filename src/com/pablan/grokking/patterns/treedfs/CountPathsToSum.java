package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CountPathsToSum {

    /**
     * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the
     * node values of each path equals ‘S’. Please note that the paths can start or end at any node but all
     * paths must follow direction from parent to child (top to bottom).
     *
     * Pablo's notes: The way to do this problem is not efficient but works. First keep track of all
     * numbers in a path, and at each step check your path backwards to see if there is a path that sums
     * 12. That way, you will always get a new path in a new level
     *
     * O(N^2), not great.. but that's what grokking has
     */
    private int paths = 0;

    public int countPaths(TreeNode root, int S) {
        this.paths = 0;
        dfs(root, S, new ArrayList<>());

        return paths;
    }

    private void dfs(TreeNode current, int target, List<Integer> currentPath) {
        if(current == null) {
            return;
        }

        currentPath.add(current.val);

        // check if there is a new target with this
        int localSum = 0;
        for(int i = currentPath.size() - 1; i >= 0; i--) {
            localSum += currentPath.get(i);
            if(localSum == target) {
                paths++;
            }
            return;
        }

        dfs(current.left, target, currentPath);
        dfs(current.right, target, currentPath);

        currentPath.remove(currentPath.size() - 1);
    }
}
