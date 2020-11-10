package com.pablan.leetcode.collection.google.hard;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInGridWithObstacleElimination {

    /**
     *  Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle). In one step,
     *  you can move up, down, left or right from and to an empty cell.
     *
     *  Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower
     *  right corner (m-1, n-1) given that you can eliminate at most k obstacles.
     *  If it is not possible to find such walk return -1.
     *
     *  Example 1:
     *
     *  Input:
     *  grid =
     *  [[0,0,0],
     *   [1,1,0],
     *   [0,0,0],
     *   [0,1,1],
     *   [0,0,0]],
     *  k = 1
     *  Output: 6
     *
     *  Explanation:
     *  The shortest path without eliminating any obstacle is 10.
     *  The shortest path with one obstacle elimination at position (3,2) is 6.
     *  Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
     *
     *  Example 2:
     *  Input:
     *  grid =
     *  [[0,1,1],
     *   [1,1,1],
     *   [1,0,0]],
     *  k = 1
     *  Output: -1
     *  Explanation:
     *  We need to eliminate at least two obstacles to find such a walk.
     *
     *  Pablo's notes. This is a normal bfs with a key difference you will be testing nodes
     *  with a K value. In other words you will keep track of visited nodes in a 3d space
     *
     *  visited[][][] means I visited row X column Y with K used, so when you generate the next nodes
     *  if they are 1 you will use 1 k and put that into the queue. Each time you tested all nodes in
     *  the level then you add a +1 to the path
     */

    // variable to represent directions. Up, Down, Left, Right
    private int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        Queue<int[]> queue = new LinkedList<>();
        int[][][] visited = new int[grid.length][grid[0].length][k];
        int steps = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++ ) {
                int[] pos = queue.poll();

                int row = pos[0];
                int column = pos[1];
                int usedK = pos[2];

                visited[row][column][usedK] = 1;

                // If I reached the target
                if(row == grid.length - 1 && column == grid[0].length - 1) {
                    return steps;
                }

                for (int j = 0; j < dir.length; j++) {
                    int nextRow = row + dir[j][0];
                    int nextColumn = column + dir[j][1];
                    int nextK = usedK;
                    // in the case I have no k left and I see and obstacle. Skip this position from processing
                    if (grid[nextRow][nextColumn] == 1 && usedK >= k) {
                        continue;
                    } else if (grid[nextRow][nextColumn] == 1) {
                        nextK++;
                    }

                    queue.offer(new int[]{nextRow, nextColumn, nextK});
                }
            }
            steps++;
        }

        // If I reach this point without reaching the corner of the grid. I can't find a path
        return -1;
    }
}
