package com.pablan.grokking.patterns.topk;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class KClosestElementsTest {

    @Test
    public void test() {
        List<Integer> result = new ArrayList<>();
        //List<Integer> result = new KClosestElements().findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
        //System.out.println("'K' closest numbers to 'X' are: " + result);

        //result = new KClosestElements().findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
        //System.out.println("'K' closest numbers to 'X' are: " + result);

        result = new KClosestElements().findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
        System.out.println("'K' closest numbers to 'X' are: " + result);
    }
}
