package com.pablan.grokking.patterns.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

    public Interval[] merge(Interval[] arr1, Interval[] arr2) {

        List<Interval> result = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while(p1 < arr1.length && p2 < arr2.length)  {
            if((arr1[p1].start >= arr2[p2].start && arr1[p1].end <= arr2[p2].end)
                || arr2[p2].start >= arr1[p1].start && arr2[p2].end <= arr1[p1].end) {
                // They overlap, we will merge them into intersection
                int start = Math.max(arr1[p1].start, arr2[p2].start);
                int end = Math.min(arr1[p1].end, arr2[p2].end);
                result.add(new Interval(start, end));
            }

            // Since we only want to get intersection just move the pointers
            if(arr1[p1].end < arr2[p2].end) {
                p1++;
            } else {
                p2++;
            }
        }

        return result.toArray(new Interval[result.size()]);
    }
}
