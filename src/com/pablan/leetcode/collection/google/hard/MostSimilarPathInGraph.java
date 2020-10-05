package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostSimilarPathInGraph {

    /**
     * We have n cities and m bi-directional roads where roads[i] = [ai, bi]
     * connects city ai with city bi. Each city has a name consisting of exactly 3 upper-case
     * English letters given in the string array names. Starting at any city x,
     * you can reach any city y where y != x (i.e. the cities and the roads are forming an undirected connected graph).
     *
     * You will be given a string array targetPath. You should find a path in the graph of the
     * same length and with the minimum edit distance to targetPath.
     *
     * You need to return the order of the nodes in the path with the minimum edit distance,
     * The path should be of the same length of targetPath and should be valid (i.e.
     * there should be a direct road between ans[i] and ans[i + 1]).
     * If there are multiple answers return any one of them.
     *
     * The edit distance is defined as follows:
     *
     * If you start at ATL, you look at target path 0. ATL == ATL ? yes, then editDistance is 0
     * Now you go to LAX, you look at target path 0. LAX == DXB? no, then editDistance is 1
     *
     * Example 1:
     *
     *
     * Input: n = 5, roads = [[0,2],[0,3],[1,2],[1,3],[1,4],[2,4]],
     * names = ["ATL","PEK","LAX","DXB","HND"], targetPath = ["ATL","DXB","HND","LAX"]
     * Output: [0,2,4,2]
     * Explanation: [0,2,4,2], [0,3,0,2] and [0,3,1,2] are accepted answers.
     * [0,2,4,2] is equivalent to ["ATL","LAX","HND","LAX"] which has edit distance = 1 with targetPath.
     * [0,3,0,2] is equivalent to ["ATL","DXB","ATL","LAX"] which has edit distance = 1 with targetPath.
     * [0,3,1,2] is equivalent to ["ATL","DXB","PEK","LAX"] which has edit distance = 1 with targetPath.
     *
     * Example 2:
     *
     * Input: n = 4, roads = [[1,0],[2,0],[3,0],[2,1],[3,1],[3,2]],
     * names = ["ATL","PEK","LAX","DXB"],
     * targetPath = ["ABC","DEF","GHI","JKL","MNO","PQR","STU","VWX"]
     * Output: [0,1,0,1,0,1,0,1]
     * Explanation: Any path in this graph has edit distance = 8 with targetPath.
     *
     * Example 3:
     *
     * Input: n = 6, roads = [[0,1],[1,2],[2,3],[3,4],[4,5]],
     * names = ["ATL","PEK","LAX","ATL","DXB","HND"],
     * targetPath = ["ATL","DXB","HND","DXB","ATL","LAX","PEK"]
     * Output: [3,4,5,4,3,2,1]
     * Explanation: [3,4,5,4,3,2,1] is the only path with edit distance = 0 with targetPath.
     * It's equivalent to ["ATL","DXB","HND","DXB","ATL","LAX","PEK"]
     *
     *
     *  Pablo's notes: https://leetcode.com/problems/the-most-similar-path-in-a-graph/discuss/791155/Java-Clean-Code-w-Comments-and-Video-Explanation.
     *
     *                0.     1.   2.   3.   4
     *   names         [ATL, PEK, LAX, DXB, HND]
     *
     *                            0.      1.         2.         3
     *    targetPath   ["ATL","DXB","HND","LAX"]
     *
     *     DO THIS STARTING AT EVERY NODE
     *     ATL at idx = 0 is it different? no, so add to cost + 0 = 0
     *         3
     *         DXB at idx = 1 is it different? no, so add to cost + 0 = 0
     *             ATL at idx = 2 is it different? yes, so add to cost + 1 = 1
     *                 DXB at idx = 3 is it different? yes, so add to cost + 1 AND RETURN = 2
     *                 LAX at idx = 3 is it different? no, so add to cost + 0 AND RETURN = 1
     *             PEK at idx = 2 is it different? yes, so add to cost + 1 = 1
     *                 DXB at idx = 3 SOLVED ALREADY RETURN PREV   RETURN
     *                 LAX at idx = 3 SOLVED ALREADY RETURN PREV
     *                 HND at idx = 3 is it different? yes, so add to cost + 1 AND RETURN
     *         LAX at idx = 1 is it different? yes, so add to cost + 1
     *             ATL at idx = 2, SOLVED ALREADY RETURN PREV
     *             PEK at idx = 2, SOLVED ALREADY RETURN PREV
     *             HND at idx = 2 is it different? no, so addto cost + 0
     *                 PEK at idx = 3 is it diffferent? yes, so add to cost +
     *                 LAX at idx = 3 SOLVED ALREADY RETURN PREV
     *
     *
     */
    Map<Integer, List<Integer>> graph;
    int[][] visited;
    int[][] nextChoiceForMin;
    String[] names;
    String[] targetPath;

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        this.graph = new HashMap<>();
        this.visited = new int[names.length][targetPath.length];
        this.nextChoiceForMin = new int[names.length][targetPath.length];
        this.names = names;
        this.targetPath = targetPath;

        for (int[] x : visited) Arrays.fill(x, -1);

        // Step1: initialize the graph
        for(int i  = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Step2: build the graph
        for(int i = 0 ; i < roads.length; i++) {
            int cityStart = roads[i][0];
            int cityEnd = roads[i][1];

            // non-directed graph
            graph.get(cityStart).add(cityEnd);
            graph.get(cityEnd).add(cityStart);
        }

        // Step3: For each city start find the min edit distance
        int minEditDistance = Integer.MAX_VALUE;
        int minEditDistanceIndex = 0;
        for(int i = 0; i < names.length; i++) {
            int editDistance = dfs(i, 0);
            if(minEditDistance > editDistance) {
                minEditDistance = editDistance;
                minEditDistanceIndex = i;
            }
        }

        // Step3: backtrack solution
        return null;

    }

    public int dfs(int namesIdx, int currPathIdx) {
        // IF WE VISITED IT ALREADY, RETURN THE PREVIOUS COUNT
        if (visited[namesIdx][currPathIdx] != -1) return visited[namesIdx][currPathIdx];

        // IF ITS DIFFERENT, ADD 1 ELSE ADD 0.
        int editDist = (names[namesIdx].equals(targetPath[currPathIdx])) ? 0 : 1;

        // IF WE FILLED UP THE PATH, WE'RE DONE
        if (currPathIdx == targetPath.length-1) return editDist;

        // FROM EACH NEIGHBOR, CALCULATE MIN COST AND SAVE THE CITY THAT GAVE THE MIN COST
        int min = Integer.MAX_VALUE;
        for (int neighbor : graph.get(namesIdx)) {
            int neighborCost = dfs(neighbor, currPathIdx+1);
            if (neighborCost < min) {
                min = neighborCost;
                nextChoiceForMin[namesIdx][currPathIdx] = neighbor; // HERE IS WHERE WE SAVE
            }
        }


        editDist += min; // UPDATE OUR EDIT DISTANCE
        visited[namesIdx][currPathIdx] = editDist; // SAVE OUR EDIT DISTANCE
        return editDist; // RETURN OUR EDIT DISTANCE
    }
}
