package com.pablan.leetcode.collection.google.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

import java.util.List;

public class DeleteNodesAndReturnForestTest {

    @Test
    public void test() {
        DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
        TreeNode one = new TreeNode(1);
        one.left = new TreeNode(2);
        one.left.left = new TreeNode(4);
        one.left.right = new TreeNode(5);

        one.right = new TreeNode(3);
        one.right.left = new TreeNode(6);
        one.right.right = new TreeNode(7);

        List<TreeNode> result = deleteNodesAndReturnForest.delNodes(one, new int[] {3, 5});
        for(TreeNode node : result) {
            System.out.println(node.val);
        }
    }
}
