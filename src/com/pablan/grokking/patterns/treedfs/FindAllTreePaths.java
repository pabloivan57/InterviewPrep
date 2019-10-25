package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {
    public List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findPaths(root, sum, currentPath, result);

        return result;
    }

    private void findPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> foundPaths) {
        if(root == null) {
            return ;
        }

        currentPath.add(root.val);

        if(root.val == sum && root.left == null && root.right == null) {
            foundPaths.add(new ArrayList<>(currentPath));
        }

        findPaths(root.left, sum - root.val, currentPath, foundPaths);
        findPaths(root.right, sum - root.val, currentPath, foundPaths);

        // remove current node from the buffer
        currentPath.remove(currentPath.size() - 1);
    }
}
