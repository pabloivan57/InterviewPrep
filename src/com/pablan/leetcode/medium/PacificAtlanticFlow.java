package com.pablan.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticFlow {

    /**
     * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
     *
     * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
     *
     * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
     *
     * Note:
     *
     * The order of returned grid coordinates does not matter.
     * Both m and n are less than 150.
     *
     *
     * Example:
     *
     * Given the following 5x5 matrix:
     *
     *   Pacific ~   ~   ~   ~   ~
     *        ~  1   2   2   3  (5) *
     *        ~  3   2   3  (4) (4) *
     *        ~  2   4  (5)  3   1  *
     *        ~ (6) (7)  1   4   5  *
     *        ~ (5)  1   1   2   4  *
     *           *   *   *   *   * Atlantic
     *
     * Return:
     *
     * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).
     *
     * Pablo's notes: The trick is to flow starting from the ocean, if at any point a coordinate has been
     * visited by two oceans then we know that will be part of our response
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        int boardLength = matrix.length;
        int boardHeight = matrix[0].length;

        Queue<Coordiante> pacific = new LinkedList<>();
        Queue<Coordiante> atlantic = new LinkedList<>();
        boolean[][] visitedAtlantic = new boolean[boardLength][boardHeight];
        boolean[][] visitedPacific = new boolean[boardLength][boardHeight];

        // fill up vertical entries
        for(int i = 0; i < boardLength; i++) {
            pacific.add(new Coordiante(i, 0));
            atlantic.add(new Coordiante(i, boardLength - 1));
        }

        // fill up horizontal entries
        for(int i = 0; i < boardLength; i++) {
            pacific.add(new Coordiante(0, i));
            atlantic.add(new Coordiante(0, boardHeight - 1));
        }

        dfs(pacific, matrix, visitedPacific);
        dfs(atlantic, matrix, visitedAtlantic);

        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0; row < boardHeight; row++) {
            for(int column = 0; column < boardLength; column++) {
                if(visitedPacific[row][column] && visitedAtlantic[row][column]) {
                    List<Integer> coordinate = new ArrayList<>();
                    coordinate.add(row);
                    coordinate.add(column);
                    result.add(coordinate);
                }
            }
        }

        return result;
    }

    private void dfs(Queue<Coordiante> queue, int[][] matrix, boolean[][] visited) {
        while(!queue.isEmpty()) {
            Coordiante current = queue.poll();
            // visit
            visited[current.row][current.column] = true;

            // Generate new coordinates
            // up
            Coordiante up = new Coordiante(current.row - 1, current.column);
            if(validCoordinate(current, up, matrix, visited)) {
                queue.add(up);
            }
            // down
            Coordiante down = new Coordiante(current.row + 1, current.column);
            if(validCoordinate(current, down, matrix, visited)) {
                queue.add(down);
            }
            // left
            Coordiante left = new Coordiante(current.row, current.column - 1);
            if(validCoordinate(current, left, matrix, visited)) {
                queue.add(left);
            }
            // right
            Coordiante right = new Coordiante(current.row, current.column + 1);
            if(validCoordinate(current, right, matrix, visited)) {
                queue.add(right);
            }
        }
    }

    private boolean validCoordinate(Coordiante parent, Coordiante coordiante, int[][] matrix, boolean[][] visited) {
        if(matrix[parent.row][parent.column] < matrix[coordiante.row][coordiante.column]) {
            return false;
        }
        
        int length = matrix.length;
        int size = matrix[0].length;

        if(coordiante.row < 0 || coordiante.row > length - 1
           || coordiante.column < 0 || coordiante.column > size - 1
           || visited[coordiante.row][coordiante.column] == true) {
            return false;
        }

        return true;
    }

    private class Coordiante {
        int row;
        int column;

        public Coordiante(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
