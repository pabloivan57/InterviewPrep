package com.pablan.leetcode.collection.google.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformEmployees {

    /**
     *  A company has n employees with a unique ID for each employee from 0 to n - 1.
     *  The head of the company has is the one with headID.
     *
     * Each employee has one direct manager given in the manager array where manager[i] is the
     * direct manager of the i-th employee, manager[headID] = -1.
     * Also it's guaranteed that the subordination relationships have a tree structure.
     *
     * The head of the company wants to inform all the employees of the company of an urgent piece of news.
     * He will inform his direct subordinates and they will inform their
     * subordinates and so on until all employees know about the urgent news.
     *
     * The i-th employee needs informTime[i] minutes to inform all of his direct
     * subordinates (i.e After informTime[i] minutes, all his direct subordinates can start spreading the news).
     *
     * Return the number of minutes needed to inform all the employees about the urgent news.
     *
     * Refer to https://leetcode.com/problems/time-needed-to-inform-all-employees/ for images
     *
     * Example 1:
     *
     * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
     * Output: 0
     * Explanation: The head of the company is the only employee in the company.
     *
     * Example 2:
     *
     * Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
     * Output: 1
     * Explanation: The head of the company with id = 2 is the direct
     * manager of all the employees in the company and needs 1 minute to inform them all.
     * The tree structure of the employees in the company is shown.
     *
     * Example 3:
     *
     *
     * Input: n = 7, headID = 6, manager = [1,2,3,4,5,6,-1], informTime = [0,6,5,4,3,2,1]
     * Output: 21
     * Explanation: The head has id = 6. He will inform employee with id = 5 in 1 minute.
     * The employee with id = 5 will inform the employee with id = 4 in 2 minutes.
     * The employee with id = 4 will inform the employee with id = 3 in 3 minutes.
     * The employee with id = 3 will inform the employee with id = 2 in 4 minutes.
     * The employee with id = 2 will inform the employee with id = 1 in 5 minutes.
     * The employee with id = 1 will inform the employee with id = 0 in 6 minutes.
     * Needed time = 1 + 2 + 3 + 4 + 5 + 6 = 21.
     * Example 4:
     *
     * Input: n = 15, headID = 0, manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
     * Output: 3
     * Explanation: The first minute the head will inform employees 1 and 2.
     * The second minute they will inform employees 3, 4, 5 and 6.
     * The third minute they will inform the rest of employees.
     * Example 5:
     *
     * Input: n = 4, headID = 2, manager = [3,3,-1,2], informTime = [0,0,162,914]
     * Output: 1076
     *
     * Pablo's notes: Look at this case
     *
     *                             ---> 1(213) -> 7(0)
     *                            /
     * 4(686)->10(337)->3(253)->9(309)->6(975) -> 2(0)
     *                            \
     *                             ---> 8(261) -> 5(170) -> 0(0)
     *
     * wrong: 686+337+253+309+975+170 = 2730
     * correct: 686+337+253+309+975 = 2560
     *
     * The above example is what makes it DFS instead of BFS
     */
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Step 1 intialize graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // Step 2 create graph
        for(int i = 0; i < n; i++) {
            int managerId = manager[i];
            if(managerId == -1) {
                continue;
            }
            List<Integer> employees = graph.get(managerId);
            employees.add(i);
            graph.put(managerId, employees);
        }

        // Step 3 bfs
        return recursiveDFS(headID, graph, informTime);
    }

    private int recursiveDFS(int root, Map<Integer, List<Integer>> graph, int[] informTime) {
        if(graph.get(root).isEmpty()) {
            return 0;
        }

        int maxChildTimeToInform = 0;
        List<Integer> children = graph.get(root);
        for(int i = 0; i < children.size(); i++) {
            maxChildTimeToInform =  Math.max(maxChildTimeToInform, recursiveDFS(children.get(i), graph, informTime));
        }

        return informTime[root] + maxChildTimeToInform;
    }
}
