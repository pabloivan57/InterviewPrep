package com.pablan.leetcode.collection.google.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import com.pablan.grokking.patterns.treedfs.PathWithGivenSequence;
import org.junit.Test;

public class PathWithGivenSequenceTest {

    @Test
    public void test() {
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(7);
        one.right = new TreeNode(9);
        one.right.left = new TreeNode(2);
        one.right.right = new TreeNode(9);

        PathWithGivenSequence pathWithGivenSequence = new PathWithGivenSequence();
        System.out.println(pathWithGivenSequence.findPath(one, new int[] {1, 9, 9}));
    }
}
