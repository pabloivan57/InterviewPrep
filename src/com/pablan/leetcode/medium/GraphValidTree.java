package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphValidTree {
    /**
     * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes),
     * write a function to check whether these edges make up a valid tree.
     *
     * Example 1:
     *
     * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
     * Output: true
     */
    public boolean validTree(int vertices, int[][] edges) {
        if(edges.length != vertices - 1) return false;

        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        // Initialize graph
        for(int i = 0; i < vertices; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Create graph
        for(int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];

            graph.get(parent).add(child);
        }

        boolean[] visited = new boolean[vertices];
        hasCycle(graph, 0, -1, visited);

        // make sure all vertices are connected
        for(int i = 0; i < vertices; i++) {
            if(!visited[i]) return false;
        }

        return true;
    }

    private boolean hasCycle(Map<Integer, List<Integer>> graph, int vertex, int parent, boolean[] visited) {
        visited[vertex] = true;

        List<Integer> children = graph.get(vertex);
        if(children == null) return false;

        for(int i = 0; i < children.size(); i++) {
            int child = children.get(i);

            if(visited[child] && child != parent) {
                /**
                 * This is for this case
                 *
                 *  1
                 *  |
                 *  2
                 *  When you are at 1 then you will visit 2, but then in 2 you will visit 1. To avoid
                 *  that circular dependency you keep track of where are we coming from
                 */
                return true;
            }

            if(hasCycle(graph, child, vertex, visited)) {
                return true;
            }
        }

        return false;
    }
}
