package com.pablan.leetcode.medium;

import com.pablan.leetcode.collection.google.medium.MissingNumber;
import org.junit.Test;

public class MissingNumberTest {

    @Test
    public void test() {
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(new int[] {2,3,5,6,7,8,9,10,11,12,13,14,15})); // should be 4
    }
}
