package com.pablan.grokking.patterns.topological;

import java.util.*;

public class TopologicalSort {

    public List<Integer> sort(int vertices, int[][] edges) {
        List<Integer> sortedOrder = new ArrayList<>();
        if(vertices <= 0) {
            return sortedOrder;
        }

        //a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph
        for (int i = 0; i < vertices; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        //b. build the graph
        for(int i = 0; i < edges.length; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            graph.get(parent).add(child); // put the child into parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        //c. find all sources i.e, all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while(!sources.isEmpty()) {
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex);

            for(int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        if(sortedOrder.size() != vertices) {
            new ArrayList<>();
        }

        return sortedOrder;
    }
}
