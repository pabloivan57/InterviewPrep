package com.pablan.leetcode.facebook;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class RobotRoomCleaner {

    private Robot robot;

    Set<Position> visited;

    // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        this.visited = new HashSet<>();
    }

    private void backtrack(int row, int col, int direction) {
        visited.add(new Position(row, col));
        robot.clean();

        // going clockwise : 0: 'up', 1: 'right', 2: 'down', 3: 'left'
        for(int i = 0; i < 4; i++) {
            // what this does is keeps moving in the same direction for the first one (number 0)
            // that simulates what 'forward' means if facing a particular direction
            int newDirection = (direction + i) % 4;
            int newRow = row + directions[newDirection][0];
            int newCol = col + directions[newDirection][0];

            if(!visited.contains(new Position(newRow, newCol)) && robot.move()) {
                backtrack(newRow, newCol, newDirection);
            }
        }
    }

    // Just this how would you go back at any position
    // 1) Move 180 degrees the opposite direction
    // 2) Move forward
    // 3) Now you're back in the same cell but facing the opposite direction, Move 180 in the opposite direction
    public void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();;
    }

    interface Robot {
        boolean move();
        void turnLeft();
        void turnRight();

        void clean();
    }

    class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return row == position.row &&
                    col == position.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
