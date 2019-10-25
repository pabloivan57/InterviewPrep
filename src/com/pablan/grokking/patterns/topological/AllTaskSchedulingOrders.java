package com.pablan.grokking.patterns.topological;

import java.util.*;

public class AllTaskSchedulingOrders {

    public void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0) {
            return;
        }

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        //b. Build the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            graph.get(parent).add(child); // put the child into it's parent's list
            inDegree.put(child, inDegree.get(child) + 1); // increment child's inDegree
        }

        //c. Find all sources
        Queue<Integer> sources = new LinkedList<>();
        for(Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);
    }

    private void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
        HashMap<Integer, Integer> inDegree, Queue<Integer> sources, List<Integer> sortedOrder) {

        if(!sources.isEmpty()) {
            for(Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCall = cloneQueue(sources);
                // only remove the current source, all other sources should remain in the queue for the next call
                sourcesForNextCall.remove(vertex);
                List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0)
                        sourcesForNextCall.add(child); // save the new source for the next call
                }

                // recursive call to print other orderings from the remaining (and new) sources
                printAllTopologicalSorts(graph, inDegree, sourcesForNextCall, sortedOrder);

                // backtrack, remove the vertex from the sorted order and put all of its children back to consider
                // the next source instead of the current vertex
                sortedOrder.remove(vertex);
                for (int child : children)
                    inDegree.put(child, inDegree.get(child) + 1);
                }
        }
    }

    // makes a deep copy of the queue
    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue)
            clone.add(num);
        return clone;
    }
}
