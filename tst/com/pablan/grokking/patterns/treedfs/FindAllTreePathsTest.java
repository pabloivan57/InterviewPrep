package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

import java.util.List;

public class FindAllTreePathsTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = new FindAllTreePaths().findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
