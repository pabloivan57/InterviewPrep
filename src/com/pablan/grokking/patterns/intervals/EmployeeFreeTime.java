package com.pablan.grokking.patterns.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class EmployeeFreeTime {

    /**
     * For ‘K’ employees, we are given a list of intervals representing the working hours of each employee.
     * Our goal is to find out if there is a free interval that is common to all employees.
     * You can assume that each list of employee working hours is sorted on the start time.
     *
     * Example 1:
     *
     * Input: Employee Working Hours=[[[1,3], [5,6]], [[2,3], [6,8]]]
     * Output: [3,5]
     * Explanation: Both the employees are free between [3,5].
     * Example 2:
     *
     * Input: Employee Working Hours=[[[1,3], [9,12]], [[2,4]], [[6,8]]]
     * Output: [4,6], [8,9]
     * Explanation: All employees are free between [4,6] and [8,9].
     * Example 3:
     *
     * Input: Employee Working Hours=[[[1,3]], [[2,4]], [[3,5], [7,9]]]
     * Output: [5,7]
     * Explanation: All employees are free between [5,7].
     */
    public List<Interval> findEmployeeFreeTime(List<List<Interval>> schedule) {
        int employees = schedule.size();

        // 1st, sort the lists // actually no, the problem is telling you to not do this because
        // they are sorted already
        // for(int i = 0; i < schedule.size(); i++) {
        //    Collections.sort(schedule.get(i), (a, b) -> a.start - b.start);
        //}

        // Step 2, create a priority Queue with at most K elements
        PriorityQueue<WorkingHour> minHeap = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);

        for(int i = 0; i < schedule.size(); i++) {
            minHeap.offer(new WorkingHour(schedule.get(i).get(0), i, 0)) ;
        }

        List<Interval> mergedIntervals = new ArrayList<>();
        Integer start = null;
        Integer end = null;
        while(!minHeap.isEmpty()) {
            WorkingHour workHour = minHeap.poll();
            Interval current = workHour.interval;

            // if they don't overlap add them to mergedIntervals
            if(start != null && end != null && end < current.start) {
                mergedIntervals.add(new Interval(start, end));
            } else if (start == null && end == null) {
                start = current.start;
                end = current.end;
            } else {
                start = Math.min(start, current.start);
                end = Math.max(end, current.end);
            }

            // add next element in the list
            int nextPosition = workHour.intervalIndex + 1;
            Interval nextInterval = schedule.get(workHour.listIndex).get(nextPosition);
            minHeap.add(new WorkingHour(nextInterval, workHour.listIndex, nextPosition));
        }

        List<Interval> result = new ArrayList<>();
        Interval interval = result.get(0);
        for(int i = 1; i < result.size(); i++) {
            Interval current = result.get(i);

            // add the interval in between
            result.add(new Interval(interval.end, current.start));

            interval = current;
        }

        return result;
    }

    private class WorkingHour {
        Interval interval;
        int listIndex;
        int intervalIndex;

        public WorkingHour(Interval interval, int listIndex, int intervalIndex) {
            this.interval = interval;
            this.listIndex = listIndex;
            this.intervalIndex = intervalIndex;
        }
    }
}
