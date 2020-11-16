package com.pablan.leetcode.collection.google.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinCostToMakeAtLeastOneValidPathInAGrid {

    /**
     * Given a m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit
     * if you are currently in this cell. The sign of grid[i][j] can be:
     *
     * 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
     * 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
     * 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
     * 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
     * Notice that there could be some invalid signs on the cells of the grid which points outside the grid.
     *
     * You will initially start at the upper left cell (0,0). A valid path in the grid is a path which starts from the upper left cell (0,0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path doesn't have to be the shortest.
     *
     * You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
     *
     * Return the minimum cost to make the grid have at least one valid path.
     *
     * Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
     * Output: 3
     * Explanation: You will start at point (0, 0).
     * The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3) change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) --> (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2, 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
     * The total cost = 3.
     *
     * Pablo's notes: Supposedly this is a variation of Djikstra which is very clever tbh
     *
     * 1.- Moving along the line means no cost... so we start at the most optimal use case to reach any square
     * 2.- First we explore with dfs the path with no cost
     * 3.- we keep track of each node visited and put in a queue
     * 4.- For each node in that queue, we attempt to change the position it travels
     * 5.- If you already visited a position then it would have less cost. Therefore you could just go there instead.
     *     Reason why an operation is not needed then
     * 6.- We keep doing this until we find the first row, col position OR we exhausted all possibilities
     * 7.- The first row, col is guaranteed to have minimal cost because we always find cells with the least cost
     */

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int[][] visited = new int[grid.length][grid[0].length];
        for(int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], -1);
        }

        dfs(grid, 0, 0, visited, 0, bfs);

        while(!bfs.isEmpty()) {

        }

        return 0;
    }

    private void dfs(int[][] grid, int row, int column, int[][] visited, int cost, Queue<int[]> bfs) {
        // if out of bounds or visited
        int rowLimit = grid.length;
        int colLimit = grid[0].length;

        if(row < 0 || row >= rowLimit || column < 0 || column >= colLimit || visited[row][column] != -1) {
            return;
        }

        // try to find the path that arrow is telling me
        int[] dir = dirs[grid[row][column] - 1];
        visited[row][column] = cost;
        bfs.offer(new int[] {row, column});
        dfs(grid, row + dir[0], column + dir[1], visited, cost, bfs);
    }
}
