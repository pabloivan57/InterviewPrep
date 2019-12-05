package com.pablan.leetcode.medium;

import com.pablan.leetcode.data.util.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    /**
     * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph.
     * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
     *
     * Pablo's notes: The idea is to use a map to clone each node and it's edges
     * !For this exercise is useful to think in terms of having the cloned map first
     * and then copy the relationships
     * For example:
     *
     * Given graph:
     *   a --> b
     *     --> c
     *
     * Map would look like
     *   node : value
     *   a : a'
     *   |   |
     *   |   |
     *   v   v
     *  b, c : b', c'
     *  --------
     *   b : b'
     *  --------
     *   c: c'
     *
     *  Here we go to a, clone a. Then iterate child and if we haven't seen b before
     *  add a new clone for b. Once that is done, then copy the relationship for a' to b'
     */
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> vertexMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        vertexMap.put(node, copy(node));

        while(!queue.isEmpty()) {
            Node current  = queue.poll();

            for(Node neighbor : current.neighbors) {
                // if we  haven't seen the neighbor
                if(!vertexMap.containsKey(neighbor)) {
                    // create copy
                    vertexMap.put(neighbor, copy(neighbor));

                    // add to process
                    queue.add(neighbor);
                }

                // copy  the edge
                vertexMap.get(current).neighbors.add(vertexMap.get(neighbor));
            }
        }

        // return the root
        return vertexMap.get(node);
    }

    public Node copy(Node node) {
        return new Node(node.val, new ArrayList<>());
    }
}
