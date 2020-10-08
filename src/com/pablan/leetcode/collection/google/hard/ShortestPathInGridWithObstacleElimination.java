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
     */

    // variable to represent directions. Up, Down, Left, Right
    private int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        //int visited[][] = new int[grid.length][grid[0].length];
        //int cost = dfs(0, 0, 0, grid, visited, k);

        //return cost == Integer.MAX_VALUE ? -1 : cost;

        return shortestPathBFS(grid, k);
    }


    public int shortestPathBFS(int[][] grid, int k) {
        int visited[][] = new int[grid.length][grid[0].length];

        Queue<GridNode> queue = new LinkedList<>();
        queue.offer(new GridNode(0, 0, k));

        int minCost = Integer.MAX_VALUE;
        int currentCost = 0;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                GridNode current = queue.poll();
                int currentRow = current.row;
                int currentColumn = current.column;
                int currentK = current.k;

                // Check if it has been visited
                if(visited[currentRow][currentColumn] == 1) {
                    continue;
                }
                if(grid[currentRow][currentColumn] == 1) {
                    currentK--;
                    if(currentK < 0) {
                        continue;
                    }
                }

                // Check if target
                if(currentRow == grid.length - 1 && currentColumn == grid[0].length - 1) {
                    minCost = Math.min(minCost, currentCost);
                }

                // visit
                visited[currentRow][currentColumn] = 1;

                for(int j = 0; j < dir.length; j++) {
                    int nextRow = currentRow + dir[j][0];
                    int nextColumn = currentColumn + dir[j][1];
                    int nextK = currentK;

                    // if it's within limits
                    if(nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length) {
                        GridNode nextNode = new GridNode(nextRow, nextColumn, nextK);
                        queue.offer(nextNode);
                    }
                }
            }
            currentCost++;
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    private class GridNode {
        public int row;
        public int column;
        public int k;

        public GridNode(int row, int column, int k) {
            this.row = row;
            this.column = column;
            this.k = k;
        }
    }

    private int dfs(int row, int column, int cost, int[][] grid, int[][] visited, int k) {
        if(row < 0
                || row > grid.length
                || column < 0
                || column > grid[0].length
                || visited[row][column] == 1) {
            return cost;
        }

        if(grid[row][column] == 1 && k < 0) {
            return Integer.MAX_VALUE;
        } else {
            k--;
        }

        // Reached target
        if(row == grid.length - 1 && column == grid[0].length - 1) {
            return cost;
        }

        // visit
        visited[row][column] = 1;

        int up = dfs(row - 1, column, cost + 1, grid, visited, k);
        int down = dfs(row + 1, column, cost + 1, grid, visited, k);
        int left = dfs(row, column - 1, cost + 1, grid, visited, k);
        int right = dfs(row, column + 1, cost + 1, grid, visited, k);

        int minCost = Math.min(up, Math.min(down, Math.min(left, right)));
        return minCost;
    }
}
