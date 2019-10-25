package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class SumOfPathNumbersTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + new SumOfPathNumbers().findSumOfPathNumbers(root));
    }
}
