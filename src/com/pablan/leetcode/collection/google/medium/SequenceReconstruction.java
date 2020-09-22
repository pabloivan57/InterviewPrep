package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class SequenceReconstruction {

    /**
     * Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs.
     * The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104.
     * Reconstruction means building a shortest common supersequence of the
     * sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it).
     * Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
     *
     *
     *
     * Example 1:
     *
     * Input: org = [1,2,3], seqs = [[1,2],[1,3]]
     * Output: false
     * Explanation: [1,2,3] is not the only one sequence that can be reconstructed,
     * because [1,3,2] is also a valid sequence that can be reconstructed.
     * Example 2:
     *
     * Input: org = [1,2,3], seqs = [[1,2]]
     * Output: false
     * Explanation: The reconstructed sequence can only be [1,2].
     * Example 3:
     *
     * Input: org = [1,2,3], seqs = [[1,2],[1,3],[2,3]]
     * Output: true
     * Explanation: The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
     * Example 4:
     *
     * Input: org = [4,1,5,2,6,3], seqs = [[5,2,6,3],[4,1,5,2]]
     * Output: true
     *
     * Pablo's notes:
     *
     * First, let's understand the problem which is poorly written btw
     *
     * EXAMPLE 1
     * seqs = [[1,2], [1,3]]
     *
     * Question: Using seqs, what are the shortest common supersequences we can make?
     * Answer: [1,2,3] and [1 3 2].
     *
     * Explanation:
     *
     * [1,2,3] is valid, since every sequence in seqs is a subsequence of [1,2,3]
     * [1,2,3]    [1,2,3]
     *  * *        *   *
     * [1,3,2] is valid since every sequence in seqs is a subsequence of [1,3,2]
     * [1,3,2]    [1,3,2]
     *  *   *      * *
     * Solution: False - there are multiple such supersequences.
     *
     * EXAMPLE 3
     * seqs = [[1,2],[1,3],[2,3]]
     *
     * Question: Using seqs, what are the shortest common supersequences we can make?
     * Answer: [1,2,3]
     *
     * Explanation:
     *
     * [1,2,3] is valid since every sequence in seqs is a subsequence of [1,2,3]
     * [1,2,3]    [1,2,3]    [1,2,3]
     *  * *        *   *        * *
     * Solution: True - solution is unique and equal to target [1,2,3].
     *
     * NOW SOMETHING YOU MUST REMEMBER IS THAT:
     *
     * What creates multiple topological orders is when you have more than one source
     * of course you have two nodes with no dependencies, you can pick any one of them next.
     * So this is precisely what you want to check. When you add sources to the queue
     * if there is more than 1 then it means of course you will have more than 1 order
     *
     * org is just there to confirm the sequence is what they were asking,  because
     * it could be seqs has a unique supersequence but it's not org
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();

        // Step 1: Create graph
        for(int i = 0; i < seqs.size(); i++) {
            List<Integer> sequence = seqs.get(i);

            for(int j = 1; j < sequence.size(); j++) {
                int source = sequence.get(j - 1);
                int target = sequence.get(j);

                if(!graph.containsKey(source)) {
                    graph.put(source, new ArrayList<>());
                    inDegree.put(source, 0);
                } else {
                    List<Integer> children = graph.get(source);
                    children.add(target);
                    graph.put(source, children);

                    // Also add inDegree  of target
                    inDegree.put(target, inDegree.getOrDefault(target, 0) + 1);
                }
            }
        }

        // Step 2: add sources to Queue
        Queue<Integer> queue = new LinkedList<>();
        Set<Map.Entry<Integer, Integer>> inDegreeEntries = inDegree.entrySet();
        for(Map.Entry<Integer, Integer> entry : inDegreeEntries) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        List<Integer> topologicalSort = new ArrayList<>();
        // Step 3: Create Topological Sort
        while(queue.isEmpty()) {
            int levelSize = queue.size();
            if(levelSize > 1) {
                // This means there is more than just one order
                return false;
            }

            for(int i = 0; i < levelSize; i++) {
                Integer node = queue.poll();
                topologicalSort.add(node);
                List<Integer> children = graph.get(node);
                for(int j = 0; i < children.size(); j++) {
                    Integer child = children.get(j);
                    inDegree.put(child, inDegree.get(child) - 1);
                    if(inDegree.get(child) == 0) {
                        // Add to queue to process
                        queue.add(child);
                    }
                }
            }
        }

        Integer[] original = Arrays.stream(org).boxed().toArray(Integer[]::new);
        return Arrays.equals(original, topologicalSort.toArray(new Integer[] {}));
    }
}
