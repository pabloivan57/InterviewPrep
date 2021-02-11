package com.pablan.grokking.patterns.intervals;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFreeTimeTest {

    @Test
    public void test() {
        EmployeeFreeTime employeeFreeTime = new EmployeeFreeTime();

        List<Interval> interval1 = new ArrayList<>();
        interval1.add(new Interval(1,3));
        interval1.add(new Interval(5,6));

        List<Interval> interval2 = new ArrayList<>();
        interval2.add(new Interval(2,3));
        interval2.add(new Interval(6,8));

        List<List<Interval>> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);

        List<Interval> result = employeeFreeTime.findEmployeeFreeTime(intervals);
        result.stream().forEach(System.out::println);
    }
}
