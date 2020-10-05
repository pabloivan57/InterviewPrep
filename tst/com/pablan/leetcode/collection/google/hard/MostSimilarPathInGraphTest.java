package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

import java.util.List;

public class MostSimilarPathInGraphTest {

    @Test
    public void test() {
        MostSimilarPathInGraph mostSimilarPathInGraph = new MostSimilarPathInGraph();

        List<Integer> result = mostSimilarPathInGraph.mostSimilar(5, new int[][] {
                {0,2},{0,3},{1,2},{1,3},{1,4},{2,4}
        },
                new String[] {"ATL","PEK","LAX","DXB","HND"},
                new String[] {"ATL","DXB","HND","LAX"});

        System.out.println(result);
    }
}
