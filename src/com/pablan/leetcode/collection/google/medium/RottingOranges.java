package com.pablan.leetcode.collection.google.medium;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RottingOranges {

    /**
     *  In a given grid, each cell can have one of three values:
     *
     * the value 0 representing an empty cell;
     * the value 1 representing a fresh orange;
     * the value 2 representing a rotten orange.
     * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
     *
     * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
     * If this is impossible, return -1 instead.
     *
     * Example 1:
     *
     *
     *
     * Input: [[2,1,1],[1,1,0],[0,1,1]]
     * Output: 4
     * Example 2:
     *
     * Input: [[2,1,1],[0,1,1],[1,0,1]]
     * Output: -1
     * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten,
     * because rotting only happens 4-directionally.
     * Example 3:
     *
     * Input: [[0,2]]
     * Output: 0
     * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
     *
     * Pablo's notes: This one is also sort of straight forward. But the trick here is that
     * you can modify the grid. Therefore you could start in each rotten orange. Also, keep track of how many
     * fresh oranges there are. Then bfs each rotten one until there are no more options. Check if you have exhausted
     * all possibilities because you could end with that weird fresh orange in the corner that you cannot access
     *
     * Put all rotten oranges in a queue, and consider a level all oranges right next to them. Do this
     * until there are not more 1's left
     *
     */
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        int time = 0;
        Queue<Coordinate> rottenOranges = new LinkedList<>();
        int freshOranges = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == 2) {
                    rottenOranges.offer(new Coordinate(row, column));
                } else if (grid[row][column] == 1) {
                    freshOranges++;
                }
            }
        }

        while (!rottenOranges.isEmpty()) {
            int levelSize = rottenOranges.size();

            for (int i = 0; i < levelSize; i++) {
                Coordinate current = rottenOranges.poll();

                for (int j = 0; j < directions.length; j++) {
                    Coordinate nextCoordinate = new Coordinate(current.row + directions[j][0],
                            current.column + directions[j][1]);

                    if (nextCoordinate.row < 0
                            || nextCoordinate.row >= grid.length
                            || nextCoordinate.column < 0
                            || nextCoordinate.column >= grid[0].length
                            || grid[nextCoordinate.row][nextCoordinate.column] == 0
                            || grid[nextCoordinate.row][nextCoordinate.column] == 2) {
                        continue;
                    }

                    grid[nextCoordinate.row][nextCoordinate.column] = 2;
                    rottenOranges.offer(nextCoordinate);
                }
            }

            time++;

        }

        return freshOranges == 0 ? time - 1 : -1;

    }

    private class Coordinate {
        int row;
        int column;

        Coordinate(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
