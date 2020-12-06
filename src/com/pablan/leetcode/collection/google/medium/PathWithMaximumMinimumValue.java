package com.pablan.leetcode.collection.google.medium;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumMinimumValue {

    /**
     *  Given a matrix of integers A with R rows and C columns,
     *  find the maximum score of a path starting at [0,0] and ending at [R-1,C-1].
     *
     * The score of a path is the minimum value in that path.
     * For example, the value of the path 8 →  4 →  5 →  9 is 4.
     *
     * A path moves some number of times from one visited cell to any neighbouring
     * unvisited cell in one of the 4 cardinal directions (north, east, west, south).
     *
     * Example 1:
     *
     * Input: [[5,4,5],[1,2,6],[7,4,6]]
     *
     * 5 4 5
     * 1 2 6
     * 7 4 6
     *
     * Output: 4
     * Explanation:
     * The path with the maximum score is highlighted in yellow.
     * 5 4 5 6 6
     *
     * Example 2:
     *
     * 2 2 1 2 2 2
     * 1 2 2 2 1 2
     *
     * Input: [[2,2,1,2,2,2],[1,2,2,2,1,2]]
     * Output: 2
     *
     * 2 2 2 2 2 2 2 2
     *
     * Pablos notes: READ AGAIN!! It says that the score of a path is the minimum value along the path
     * So what this really asking is "Give me the shortest path, with the maximum score I can get" .That
     * gives you two hints
     *
     * 1.- Shortest Path = BFS
     * 2.- Maximum score I can get = Math.max --> BUT, it says the path score is the minimum value along the path
     *
     * That means you will keep the minimum of the score while doing BFS.
     *
     * Now, if you start selecting the minimum score you will have to deal with a bunch of checks
     * imagine starting at 5
     *
     * 5 can go to 4, 1 or 2. You can choose the minimum which will be the path score... but because it says maximize
     * it you have to check go with 4. So basically something like choose the max of the level and keep exploring it.
     * Now take note of all the paths that reach the destination and pick the one with the smallest score.
     *
     * Now all the craziness above boils down to, do BFS and at every step start exploring the max number. If the
     * new number represents the the path's minimum then keep that as the score and put that node in the queue (this
     * means you keep track of a node with row, column and min score at this point) again
     * to further explore. What that means is that at this node the minimum path is 'score'
     */
    int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinimumPath(int[][] A) {
        int maxScore = 0;
        boolean[][] visited = new boolean[A.length][A[0].length];

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        queue.offer(new int[]{0, 0, A[0][0]});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];
            int pathScore = current[2];

            maxScore = Math.min(maxScore, pathScore);

            if(row == A.length - 1 && col == A[0].length - 1) {
                // because we look at the min from high to low we are guaranteed to find the min score at this point
                // max score should be the min from last level. Therefore only way it could have change is it target
                // was less than maxScore
                break;
            }

            // generate next steps
            for(int i = 0; i < dir.length; i++) {
                int nextRow = row + dir[i][0];
                int nextCol = col + dir[i][1];
                int nextScore = maxScore;

                if(nextRow > 0 && nextRow < A.length && nextCol > 0 && nextCol < A[0].length && !visited[nextRow][nextCol]) {
                    queue.offer(new int[]{nextRow, nextCol, nextScore});
                }
            }
        }

        return -1;
    }
}
