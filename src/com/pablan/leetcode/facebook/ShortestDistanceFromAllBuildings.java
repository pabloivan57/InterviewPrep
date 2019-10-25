package com.pablan.leetcode.facebook;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    public int shortestDistance(int[][] grid) {

        // clear corner cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return-1;

        final int rows = grid.length;
        final int columns = grid[0].length;

        int[][] distance = new int[rows][columns];
        int[][] access = new int[rows][columns];
        int buildings = 0; // variable just to keep track of how many buildings the grid has

        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {

                // because we can have 1 or 2
                if(grid[row][column] != 1) continue;

                // found 1 building
                buildings++;

                // level order dfs
                int level = 0;
                Queue<Point> queue = new LinkedList<>();
                // normal graph dfs, visited array
                boolean[][] visited = new boolean[rows][columns];
                queue.offer(new Point(row, column));
                while(queue.isEmpty()) {
                    Point currentPoint = queue.poll();
                    if(visited[currentPoint.row][currentPoint.column] == true) continue;;

                    int levelSize = queue.size();
                    for(int i = 0; i < levelSize; i++) {
                        visited[currentPoint.row][currentPoint.column] = true;
                        if(grid[currentPoint.row][currentPoint.column] == 0) {
                            access[currentPoint.row][currentPoint.column]++;
                            distance[currentPoint.row][currentPoint.column] += level;
                        }
                    }

                    //add neighbors to dfs stack
                    if(currentPoint.column + 1  < columns
                            && grid[currentPoint.row][currentPoint.column] == 0
                            && !visited[currentPoint.row][currentPoint.column]) {
                        // If we can add this to the stack
                        queue.offer(new Point(currentPoint.row, currentPoint.column + 1));
                    }
                    // Same row, left side col
                    if (currentPoint.column-1 >= 0
                            && grid[currentPoint.row][currentPoint.column-1] == 0
                            && !visited[currentPoint.row][currentPoint.column-1]) {
                        queue.offer(new Point(currentPoint.row, currentPoint.column-1));
                    }
                    // One row below, same col
                    if (currentPoint.row+1 < rows
                            && grid[currentPoint.row+1][currentPoint.column] == 0
                            && !visited[currentPoint.row+1][currentPoint.column]) {
                        queue.offer(new Point(currentPoint.row+1, currentPoint.column));
                    }
                    // One row up, same col
                    if (currentPoint.row-1 >= 0 && grid[currentPoint.row-1][currentPoint.column] == 0
                            && !visited[currentPoint.row-1][currentPoint.column]) {
                        queue.offer(new Point(currentPoint.row-1, currentPoint.column));
                    }

                    level++;
                }
            }
        }

        int shortestDistance = Integer.MAX_VALUE;
        // Now that we have the data we want, we need to find
        // the point that can access all buildings with the least amount of distance
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(access[row][column] == buildings) {
                    shortestDistance = Math.min(shortestDistance, distance[row][column]);
                }
            }
        }

        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    class Point {
        int row;
        int column;

        public Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
