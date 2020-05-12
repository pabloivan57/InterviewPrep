package com.pablan.leetcode.collection.google.medium;

import com.pablan.grokking.patterns.treebfs.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    /**
     * Given the root of a binary tree, each node in the tree has a distinct value.
     *
     * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
     *
     * Return the roots of the trees in the remaining forest.  You may return the result in any order.
     *
     * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
     * Output: [[1,2,null,4],[6],[7]]
     *
     * Pablo's notes: The trick here is to keep the values you know will go into the resulting list. For example
     * the root, we know it will go into the list because is the starting point, then the next one we are interested in
     * is the node after we deleted and intermediate child. In other words
     * if(node is is_delete) then node.left goes to list and node.right goes to list. In other words they become
     * roots. From this you know that if a node is root and is not in the to_delete list
     * then you add it to the list
     * Now, when you delete something you remove it's connection. For example in above
     *        1
     *    2       3 -> this is deleted      In other words, 1.right == null at the end
     * 4    5   6  7
     */
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for(int i = 0; i < to_delete.length; i++) {
            toDelete.add(to_delete[i]);
        }
        List<TreeNode> result = new ArrayList<>();
        inOrder(root, true, result, toDelete);

        return result;
    }

    public TreeNode inOrder(TreeNode current, boolean isRoot, List<TreeNode> result, Set<Integer> toDelete) {
        if(current == null) {
            return null;
        }

        if(isRoot && !toDelete.contains(current.val)) {
            result.add(current);
        }

        boolean isDeleted = toDelete.contains(current.val) ? true : false;

        current.left = inOrder(current.left,  isDeleted, result, toDelete);
        current.right = inOrder(current.right, isDeleted, result, toDelete);

        if(isDeleted) {
            return null;
        }

        return current;
    }
}
