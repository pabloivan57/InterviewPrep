package com.pablan.leetcode.easy;

import com.pablan.leetcode.medium.ReverseInteger;
import org.junit.Test;

public class ReverseIntegerTest {

    @Test
    public void test() {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(123));
        System.out.println(reverseInteger.reverse(-123));
        System.out.println(reverseInteger.reverse(120));
    }
}
