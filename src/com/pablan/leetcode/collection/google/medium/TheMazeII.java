package com.pablan.leetcode.collection.google.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

    /**
     *  There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down,
     *  left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
     *
     * Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop
     * at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start
     * position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
     *
     * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume
     * that the borders of the maze are all walls. The start and destination coordinates are
     * represented by row and column indexes.
     *
     *
     *
     * Example 1:
     *
     * Input 1: a maze represented by a 2D array
     *
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     *
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (4, 4)
     *
     * Output: 12
     *
     * Explanation: One shortest way is : left -> down -> left -> down -> right -> down -> right.
     *              The total distance is 1 + 1 + 3 + 1 + 2 + 2 + 2 = 12.
     *
     * Example 2:
     *
     * Input 1: a maze represented by a 2D array
     *
     * 0 0 1 0 0
     * 0 0 0 0 0
     * 0 0 0 1 0
     * 1 1 0 1 1
     * 0 0 0 0 0
     *
     * Input 2: start coordinate (rowStart, colStart) = (0, 4)
     * Input 3: destination coordinate (rowDest, colDest) = (3, 2)
     *
     * Output: -1
     *
     * Explanation: There is no way for the ball to stop at the destination.
     *
     * Pablo's notes: This is a modification of DFS. We basically keep moving
     * the same direction until there is a wall. And keep that in a queue to explore later.
     * Then go back to the position and try the next direction until you hit a wall. Save it to explore later
     * At every step you keep track of the distance you visited the the grid. let's say
     * you can hit position (x, y) from start by taking left and down (eventually). If you take left
     * you will reach x,y with 3 cost. But if you take down... you will get there with 1 cost. Therefore you don't
     * care anymore about 3 cost and override the array to say that the shortest path to that cell so far is 1
     *
     * Now, you will hear this is a modification of Djikstra and it's true to some degree. that is because you will
     * find that is smarter to always process first the shortest values from the queue. Think about it you have a
     * better chance of finding a path to destination from a shorter path already than starting from a long path... although
     * not always
     *
     */
    private int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] shortestLengths = new int[maze.length][maze[0].length];
        for(int i = 0; i < shortestLengths.length; i++) {
            Arrays.fill(shortestLengths[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>(); // int[] will have x,y and current length to cell
                                                 // we can use a PriorityQueue sorted by length as optimization
        queue.offer(new int[]{start[0], start[1], 0});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < dir.length; i++) {
                int row = current[0];
                int column = current[1];
                int length = current[2];

                while(row > 0 && row < maze.length && column > 0 && column < maze[0].length) {
                    row += dir[i][0];
                    column += dir[i][1];
                    length += 1;
                }

                row -= dir[i][0];
                column -= dir[i][1];
                length -= 1;

                if(shortestLengths[row][column] < length) continue;
                shortestLengths[row][column] = length;

                queue.offer(new int[] {row, column, length});
            }
        }

        return maze[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : maze[destination[0]][destination[1]];
    }

}
