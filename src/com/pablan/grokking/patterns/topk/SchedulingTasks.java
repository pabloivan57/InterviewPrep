package com.pablan.grokking.patterns.topk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SchedulingTasks {

    /**
     * You are given a list of tasks that need to be run, in any order, on a server.
     * Each task will take one CPU interval to execute but once a task has finished,
     * it has a cooling period during which it can’t be run again. If the cooling period for all tasks is ‘K’
     * intervals, find the minimum number of CPU intervals that the server needs to finish all tasks.
     *
     * If at any time the server can’t execute any task then it must stay idle.
     *
     * Example 1:
     *
     * Input: [a, a, a, b, c, c], K=2
     * Output: 7
     * Explanation: a -> c -> b -> a -> c -> idle -> a
     * Example 2:
     *
     * Input: [a, b, a], K=3
     * Output: 5
     * Explanation: a -> b -> idle -> idle -> a
     *
     * Pablo's notes: Similar to Rearrange String. The trick here is to process n+1 items from the maxHeap
     * at a time. Each time you process put them in a waitlist, because you came 1 by one from max heap and
     * you reduce -1 on each... next time you put them in the maxHeap they will maintain order. So for example:
     *
     * a -> 3
     * b -> 1
     * c -> 2
     *
     * Once you process a you have to wait k more steps. That is k + 1 including that a. Here is the visual representation
     * K=2... next time we process a we will be in step 3
     *
     * a ... step 1
     * b ... step 2, cooldown a = 1
     * c ... step 3, cooldown a = 2 == k
     * I can process a, b in that order again. So we have a queue (a -> b == this is because a and b had 1 left)
     * a ...
     * b ... etc
     *
     * Now, let's imagine you don't have K == 3 steps as in example 2, we need to process n + 1 == 4
     * [a, b, a]
     * a ... step 1
     * b ... step 2
     * (a -> b) is in the queue
     * (I don't have more elements in max heap)
     * Because I have 2 let I need 2 idles
     * idle --> idle... now I can process a -> b again, put them back on maxHeap
     * a ...
     * b ...
     */
    public int scheduleTasks(char[] tasks, int k) {
        Map<Character, Integer> occurrences = new HashMap<>();
        for(int i = 0; i < tasks.length; i++) {
            occurrences.put(tasks[i], occurrences.getOrDefault(tasks[i], 0) + 1);
        }

        // Load the entries in the maxHeap
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Character, Integer> entry : occurrences.entrySet()) {
            maxHeap.offer(entry);
        }

        // Start processing jobs
        int cpuCycles = 0;
        while(!maxHeap.isEmpty()) {
            int n = k + 1;
            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            while(n > 0 && !maxHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = maxHeap.poll();
                entry.setValue(entry.getValue() - 1);
                cpuCycles++;
                if(entry.getValue() > 0) {
                    // only if I have more processes add them to the waitlist
                    waitList.add(entry);
                }
                n--;
            }

            // Put eligible processes in the heap
            maxHeap.addAll(waitList);

            // remaining n cycles that couldn't be jobs are idle, just check maxHeap.isEmpty
            // in case we finished processing all jobs in the last step
            if(!maxHeap.isEmpty()) {
                cpuCycles += n;
            }
        }

        return cpuCycles;
    }
}
