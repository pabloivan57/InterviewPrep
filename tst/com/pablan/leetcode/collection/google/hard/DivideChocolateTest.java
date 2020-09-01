package com.pablan.leetcode.collection.google.hard;

import org.junit.Test;

public class DivideChocolateTest {

    @Test
    public void test() {
        DivideChocolate divideChocolate = new DivideChocolate();
        System.out.println(divideChocolate.maximizeSweetness(new int[] {1,2,3,4,5,6,7,8,9}, 5)); //should be 6
        System.out.println(divideChocolate.maximizeSweetness(new int[] {5,6,7,8,9,1,2,3,4}, 8)); //should be 1
        System.out.println(divideChocolate.maximizeSweetness(new int[] {1,2,2,1,2,2,1,2,2}, 2)); //should be 5
    }
}
