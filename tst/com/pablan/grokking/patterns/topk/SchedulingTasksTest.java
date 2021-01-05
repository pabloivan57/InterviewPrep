package com.pablan.grokking.patterns.topk;

import org.junit.Test;

public class SchedulingTasksTest {

    @Test
    public void test() {
        SchedulingTasks schedulingTasks = new SchedulingTasks();
        System.out.println(schedulingTasks.scheduleTasks(new char[]{'a', 'a', 'a', 'b', 'c', 'c'}, 2));
        System.out.println(schedulingTasks.scheduleTasks(new char[]{'a', 'b', 'a'}, 3));
    }
}
