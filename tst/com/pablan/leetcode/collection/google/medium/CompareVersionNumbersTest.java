package com.pablan.leetcode.collection.google.medium;

import org.junit.Test;

public class CompareVersionNumbersTest {

    @Test
    public void test() {
        CompareVersionNumbers compareVersionNumbers = new CompareVersionNumbers();
        System.out.println(compareVersionNumbers.compareVersion("1.01", "1.001")); // 0
        System.out.println(compareVersionNumbers.compareVersion("1.0", "1.0.0")); // 0
        System.out.println(compareVersionNumbers.compareVersion("1.0.1", "1")); // 1

    }
}
