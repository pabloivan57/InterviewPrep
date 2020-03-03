package com.pablan.leetcode.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromPreorderInorder {

    // start from preorder
    int preorder_idx;
    Map<Integer, Integer> inOrderIndexes = new HashMap<>();
    int[] preorder;
    int[] inorder;

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
        this.preorder = preorder;
        this.preorder_idx = 0;
        this.inorder = inorder;

        for(int i = 0; i < inorder.length; i++) {
            inOrderIndexes.put(inorder[i], i);
        }

        return createTree(0, preorder.length);
    }

    public TreeNode createTree(int start, int end) {
        if(start == end) {
            return null;
        }

        if(preorder_idx >= preorder.length) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preorder_idx++]);

        int inorder_idx = inOrderIndexes.get(node.val);

        node.left = createTree(start, inorder_idx);
        node.right = createTree(inorder_idx + 1, end);

        return node;
    }

}
