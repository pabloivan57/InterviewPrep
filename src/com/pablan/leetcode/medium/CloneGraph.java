package com.pablan.leetcode.medium;

import com.pablan.leetcode.data.util.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

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
