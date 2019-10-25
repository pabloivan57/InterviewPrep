package com.pablan.grokking.patterns.treebfs;

import org.junit.Test;

public class ConnectLevelOrderSiblingsTest {

    @Test
    public void test() {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        new ConnectLevelOrderSiblings().connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        printLevelOrder(root);
    }

    // level order traversal using 'next' pointer
    void printLevelOrder(TreeNode nextLevelRoot) {
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
        while (current != null) {
            System.out.print(current.val + " ");
            if (nextLevelRoot == null) {
            if (current.left != null)
                nextLevelRoot = current.left;
            else if (current.right != null)
                nextLevelRoot = current.right;
            }
            current = current.next;
        }
        System.out.println();
        }
     }
}
