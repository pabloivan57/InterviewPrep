package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    /**
     *
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     *
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     *
     * Example 1:
     *
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     *              To take course 1 you should have finished course 0. So it is possible.
     **/

    // This all comes down to finding the topological sort of the courses
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer,  Integer> inDegree = new HashMap<>();

        // initialize vertex
        for(int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }

        // create graph
        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];

            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) +  1);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        // add sources
        for(Map.Entry<Integer, Integer> entry :  inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        while(!queue.isEmpty()) {
            Integer node = queue.poll();
            // add source to order
            result.add(node);

            List<Integer> children = graph.get(node);
            for(Integer child : children) {
                inDegree.put(child, inDegree.get(child) - 1);

                if(inDegree.get(child) == 0) {
                    queue.add(child);
                }
            }
        }

        return result.size() == numCourses ? true : false;
    }

}
