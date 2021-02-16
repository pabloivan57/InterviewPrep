package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class NumberOfConnectedComponents {

    /**
     * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to find the number of connected components in an undirected graph.
     *
     * Example 1:
     *
     * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
     *
     *      0          3
     *      |          |
     *      1 --- 2    4
     *
     * Output: 2
     * Example 2:
     *
     * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
     *
     *      0           4
     *      |           |
     *      1 --- 2 --- 3
     *
     * Output:  1
     *
     * You can assume that no duplicate edges will appear in edges.
     * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
     *
     * At first glance you might think just counting the sources is enough. But here is the counter example:
     *
     * [[1,0],[2,0]]
     *
     *  1
     *    \
     *     \
     *      0
     *     /
     *    /
     *  2
     *
     *  In the case above the inDegree for 1 and 2 is 0. So this will make a mistake thinking there are 2 components
     *  if we just count inDegree. But in reality there is only 1. Therefore the solution is to assume the graph is
     *  bidirectional, but avoid the circles by checking if you're not coming from the parent node
     *
     *  0  -- > 1
     *  0  <--  1
     */
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Initialize graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Construct graph, keep in mind is undirected, so nodes are connected both ways
        for(int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            graph.get(parent).add(child);
            graph.get(child).add(parent);
        }

        boolean[] visited = new boolean[n];
        int numComponents = 0;
        for(int i = 0; i < n; i++) {
            if(visited[i] != true) {
                numComponents++;

                // BFS
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);

                while(!queue.isEmpty()) {
                    Integer current = queue.poll();
                    // visit node
                    visited[current] = true;
                    List<Integer> children = graph.get(current);
                    for(Integer child : children) {
                        if(visited[child] != true) {
                            queue.add(child);
                        }
                    }
                }
            }
        }

        return numComponents;
    }
}
