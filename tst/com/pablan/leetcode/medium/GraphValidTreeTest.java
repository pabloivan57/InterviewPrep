package com.pablan.leetcode.medium;

import org.junit.Test;

public class GraphValidTreeTest {

    @Test
    public void test() {
        GraphValidTree graphValidTree = new GraphValidTree();
        //System.out.println(graphValidTree.validTree(5, new int[][] {{0,1}, {0,2}, {0,3}, {1,4}}));
        System.out.println(graphValidTree.validTree(2, new int[][] {{1,0}}));
    }
}
