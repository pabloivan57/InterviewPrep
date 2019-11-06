package com.pablan.leetcode.easy;

import org.junit.Test;

public class ValidAnagramTest {

    @Test
    public void test() {
        ValidAnagram validAnagram = new ValidAnagram();

        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
        System.out.println(validAnagram.isAnagram("aacc", "ccac"));
    }
}
