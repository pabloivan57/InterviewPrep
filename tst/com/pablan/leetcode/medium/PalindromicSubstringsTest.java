package com.pablan.leetcode.medium;

import org.junit.Test;

public class PalindromicSubstringsTest {

    @Test
    public void test() {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("abc"));
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }
}
