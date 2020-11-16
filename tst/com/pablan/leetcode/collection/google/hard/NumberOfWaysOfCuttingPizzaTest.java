package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class NumberOfWaysOfCuttingPizzaTest {

    @Test
    public void test() {
        NumberOfWaysOfCuttingPizza numberOfWaysOfCuttingPizza = new NumberOfWaysOfCuttingPizza();
        System.out.println(numberOfWaysOfCuttingPizza.ways(new String[] {"A..","AAA","..."}, 3));
    }
}
