package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class DivideArrayInSetsOfKConsecutiveNumbersTest {

    @Test
    public void test() {
        DivideArrayInSetsOfKConsecutiveNumbers divideArrayInSetsOfKConsecutiveNumbers = new DivideArrayInSetsOfKConsecutiveNumbers();
        System.out.println(divideArrayInSetsOfKConsecutiveNumbers.isPossibleDivide(new int[] {1,2,3,3,4,4,5,6}, 4)); // should be true
    }
}
