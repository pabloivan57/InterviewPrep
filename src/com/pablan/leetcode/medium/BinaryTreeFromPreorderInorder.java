package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderInorder {

    // start from preorder
    int pre_idx = 0;
    Map<Integer, Integer> inOrderIndexes = new HashMap<>();
    int[] inorder;
    int[] preorder;

    /**
     *
     * preorder = [3,9,20,15,7]
     * inorder = [9,3,15,20,7]
     *
     * The two of them together have an interesting property
     * the value that you pick in preorder divides the inOrder in half,
     * for example let's say you have 3 from preorder (a.k.a root)
     * that corresponds to index 1 in the inorder array and divides the tree in two parts
     *             3
     *       9        15,20,7 -> to be arranged
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder = inorder;
        this.preorder = preorder;

        for(int i = 0; i < inorder.length; i++) {
            inOrderIndexes.put(inorder[i], i);
        }

        return createTree(0, preorder.length);

    }

    private TreeNode createTree(int leftPointer, int rightPointer) {
        if(leftPointer == rightPointer) {
            return null;
        }

        int rootValue = preorder[pre_idx];
        TreeNode root = new TreeNode(rootValue);
        // splits into left and right subtree
        int splitIndex = inOrderIndexes.get(rootValue);

        // visited root, move to the next preOrder
        pre_idx++;

        root.left = createTree(leftPointer, splitIndex);
        root.right = createTree(splitIndex + 1, rightPointer);

        return root;
    }
}
