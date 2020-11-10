package com.pablan.leetcode.collection.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class JumpGameIV {

    /**
     *  Given an array of integers arr, you are initially positioned at the first index of the array.
     *
     * In one step you can jump from index i to index:
     *
     * i + 1 where: i + 1 < arr.length.
     * i - 1 where: i - 1 >= 0.
     * j where: arr[i] == arr[j] and i != j.
     * Return the minimum number of steps to reach the last index of the array.
     *
     * Notice that you can not jump outside of the array at any time.
     *
     *
     *
     * Example 1:
     *
     * Input: arr = [100,-23,-23,404,100,23,23,23,3,404]
     * Output: 3
     * Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last
     * index of the array.
     * Example 2:
     *
     * Input: arr = [7]
     * Output: 0
     * Explanation: Start index is the last index. You don't need to jump.
     * Example 3:
     *
     * Input: arr = [7,6,9,6,9,6,9,7]
     * Output: 1
     * Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
     * Example 4:
     *
     * Input: arr = [6,1,9]
     * Output: 2
     * Example 5:
     *
     * Input: arr = [11,22,7,7,7,7,7,7,7,22,13]
     * Output: 3
     */
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> indexes = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(!indexes.containsKey(arr[i])) {
                indexes.put(arr[i], new ArrayList<>());
            }
            indexes.get(arr[i]).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[0] = true;
        queue.offer(0);

        int steps = 0;
        // bfs is guaranteed to find the min distance
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                Integer current = queue.poll();
                if(current == arr.length - 1) {
                    return steps;
                }
                List<Integer> next = indexes.get(arr[current]);
                next.add(current - 1);
                next.add(current + 1);
                for(int j = 0; j < next.size(); j++) {
                    Integer nextIndex = next.get(j);
                    if(nextIndex > 0 && nextIndex < arr.length && visited[nextIndex] == false) {
                        visited[nextIndex] = true;
                        queue.offer(nextIndex);
                    }
                }
                next.clear(); // This is important, once we put to process  and visited all indexes of that value
                              // we want to stop them from being considered again. Perfect example is
                              // [7, 7, 7, 7, 7, 7, 7, 7, 1, 2, 3]
            }
            steps++;
        }

        return -1;
    }
}
