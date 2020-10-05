package com.pablan.leetcode.collection.google.hard;

public class RangeModule {


    /**
     *  A Range Module is a module that tracks ranges of numbers.
     *  Your task is to design and implement the following interfaces in an efficient manner.
     *
     * addRange(int left, int right) Adds the half-open interval [left, right),
     * tracking every real number in that interval. Adding an interval that partially overlaps
     * with currently tracked numbers should add any numbers in the interval [left, right)
     * that are not already tracked.
     *
     * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right)
     * is currently being tracked.
     * removeRange(int left, int right) Stops tracking every real number currently being tracked in the
     * interval [left, right).
     * Example 1:
     *
     * addRange(10, 20): null
     * removeRange(14, 16): null
     * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
     * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
     * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
     */

    private TreeNode root;

    public RangeModule() {
        root = null;
    }

    public void addRange(int left, int right) {
        addRange(root, left, right);
    }

    public boolean queryRange(int left, int right) {
        return queryRange(root, left, right);
    }

    public void removeRange(int left, int right) {
        removeRange(root, left, right);
    }


    public TreeNode addRange(TreeNode node, int left, int right) {
        if(left >= right) {
            return node;
        }

        if(node == null) {
            return new TreeNode(left, right);
        }

        // case 1, intervals do not intersect
        //  case 1.1 interval is on the left of node
        if(right <= node.start) {
            addRange(node.left, left, right);
        //  case 1.2 interval is on the right of root
        } else if (left >= node.end) {
            addRange(node.right, left, right);
        // case 2 intersections, in that case we split the intersections
        // not covered by 2 and pass them to left & right
        } else {
            node.left = addRange(node.left, left, node.start);
            node.right = addRange(node.right, node.end, right);
        }

        return node;
    }

    public boolean queryRange(TreeNode node, int left, int right) {
        if(left >= right) {
            return false;
        }

        if(node == null) {
            return false;
        }

        // if it's inside the interval
        if(left > node.start && right < node.end) {
            return true;
        }

        // case 1 intervals do not intersect left
        if(right <  node.start) {
            return queryRange(node.left, left, right);
        // case 2 intervals do not intersect right
        } else if(node.end < left) {
            return queryRange(node.right, left, right);
        } else {
            // case 3 they intersect, try parts of the interval that fall off current node
            return queryRange(node.left, left, node.start) && queryRange(node.right, node.end, right);
        }
    }

    public TreeNode removeRange(TreeNode node, int left, int right) {
        if (left >= right) return node;
        if (node == null) return node;
        if (node.end <= left) {
            node.right = removeRange(node.right, left, right);
        } else if (node.start >= right) {
            node.left = removeRange(node.left, left, right);
        } else {
            node.left = removeRange(node.left, left, node.start);
            node.right = removeRange(node.right, node.end, right);
            node.left = addRange(node.left, node.start, left);
            node.right = addRange(node.right, right, node.end);
            node = remove(node);
        }
        return node;
    }

    private TreeNode remove(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) return node.right;
        TreeNode leftLargest = getLargest(node.left, node);
        leftLargest.left = node.left;
        leftLargest.right = node.right;
        return leftLargest;
    }

    private TreeNode getLargest(TreeNode node, TreeNode parent) {
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        if (node == parent.left) parent.left = node.left;
        if (node == parent.right) parent.right = node.left;
        node.left = null;
        return node;
    }

    private static class TreeNode {
        public TreeNode left;
        public TreeNode right;

        public int start;
        public int end;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
