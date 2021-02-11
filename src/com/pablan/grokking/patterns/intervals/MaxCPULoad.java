package com.pablan.grokking.patterns.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class MaxCPULoad {

    /**
     * We are given a list of Jobs. Each job has a Start time, an End time, and a CPU load when it is running.
     * Our goal is to find the maximum CPU load at any time if all the jobs are running on the same machine.
     */
    public int findMaxCPULoad(int[][] jobs) {
        List<Job> jobsList = new ArrayList<>();
        for(int i = 0; i < jobs.length; i++) {
            jobsList.add(new Job(jobs[i][0], jobs[i][1], jobs[i][2]));
        }
        return findMaxCPULoad(jobsList);
    }

    public int findMaxCPULoad(List<Job> jobs) {
        Collections.sort(jobs, (a, b) -> a.start - b.start);

        int cpuLoad = 0;
        int maxLoad = 0;
        PriorityQueue<Job> concurrentJobs = new PriorityQueue<>((a, b) -> a.end - b.end);
        for(int i = 0; i < jobs.size(); i++) {
            Job current = jobs.get(i);

            while(!concurrentJobs.isEmpty() && concurrentJobs.peek().end < current.start) {
                Job finishedJob = concurrentJobs.poll();
                cpuLoad = cpuLoad - finishedJob.load;
            }

            concurrentJobs.offer(current);
            cpuLoad = cpuLoad + current.load;
            maxLoad = Math.max(cpuLoad, maxLoad);
        }

        return maxLoad;
    }

    private class Job {
        int start;
        int end;
        int load;

        public Job(int start, int end, int load) {
            this.start = start;
            this.end = end;
            this.load = load;
        }
    }
}
