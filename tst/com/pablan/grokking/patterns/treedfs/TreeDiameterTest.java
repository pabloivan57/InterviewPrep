package com.pablan.grokking.patterns.treedfs;

import com.pablan.grokking.patterns.treebfs.TreeNode;
import org.junit.Test;

public class TreeDiameterTest {

    @Test
    public void test() {
        TreeDiameter treeDiameter = new TreeDiameter();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + treeDiameter.findDiameter(root)); // should be 5
    }
}
