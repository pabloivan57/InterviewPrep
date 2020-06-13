package com.pablan.leetcode.collection.google.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class OpenTheLock {

    /**
     *  You have a lock in front of you with 4 circular wheels.
     *  Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
     *  he wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
     *  Each move consists of turning one wheel one slot.
     *
     * The lock initially starts at '0000', a string representing the state of the 4 wheels.
     *
     * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
     * the wheels of the lock will stop turning and you will be unable to open it.
     *
     * Given a target representing the value of the wheels that will unlock the lock,
     * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
     *
     * Example 1:
     *
     * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * Output: 6
     * Explanation:
     * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
     * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
     * because the wheels of the lock become stuck after the display becomes the dead end "0102".
     * Example 2:
     *
     * Input: deadends = ["8888"], target = "0009"
     * Output: 1
     * Explanation:
     * We can turn the last wheel in reverse to move from "0000" -> "0009".
     * Example 3:
     *
     * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
     * Output: -1
     * Explanation:
     * We can't reach the target without getting stuck.
     * Example 4:
     *
     * Input: deadends = ["0000"], target = "8888"
     * Output: -1
     *
     * Pablo's notes: Simple BFS, just keep going 1 by 1 the possibilities until you hit the target
     * don't expand if it's a dead end. For example: we start in 0000, you can try 1000 or 9000, then keep going
     * 1000 -> 2000, 1100, 1900, 1010, 1090, 1001, 1009, etc.
     *
     * Rember, Level traversal is the same as BFS
     *
     */
    public int openLock(String[] deadends, String target) {
        Set<String> ends = new HashSet<>();
        for(String deadend : deadends) {
            ends.add(deadend);
        }

        Queue<String> queue = new LinkedList<>();
        queue.add("0000");

        // The answer asks how many jumps starting from 0000
        // that's why we count the first one as level 0
        int level = -1;
        Set<String> visited = new HashSet<>();
        while(!queue.isEmpty()) {
            int items = queue.size();
            level++;
            // Explore level
            for(int i = 0; i < items; i++) {
                String combination = queue.poll();

                // Skip if already visited or this is a deadend
                if(visited.contains(combination) || ends.contains(combination)) {
                    continue;
                }

                // visit node
                visited.add(combination);

                // check if it's target
                if(combination.equals(target)) {
                    return level;
                } else {
                    // for each number in the combination try +1 and -1
                    for(int index = 0; index < combination.length(); index++) {
                        int number = combination.charAt(index) - '0';
                        int firstPossibility = ((number + 1) + 10) % 10;
                        int secondPossibility = ((number - 1) + 10) % 10;

                        queue.add(combination.substring(0, index) + firstPossibility + combination.substring(index + 1));
                        queue.add(combination.substring(0, index) + secondPossibility + combination.substring(index + 1));
                    }
                }
            }
        }

        return -1;
    }
}
