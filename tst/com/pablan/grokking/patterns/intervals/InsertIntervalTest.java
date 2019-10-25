package com.pablan.grokking.patterns.intervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalTest {

    @Test
    public void test() {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : new InsertInterval().insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
        //[[1,3], [4,7], [8,12]]

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : new InsertInterval().insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
        //[[1,3], [4,12]]

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : new InsertInterval().insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
        //[[1,4], [5,7]]
    }
}
