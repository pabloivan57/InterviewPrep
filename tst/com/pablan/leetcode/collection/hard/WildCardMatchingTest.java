package com.pablan.leetcode.collection.hard;

import org.junit.Test;

public class WildCardMatchingTest {

    @Test
    public void test() {
        WildcardMatching wildcardMatching = new WildcardMatching();
        //System.out.println(wildcardMatching.isMatch("adceb", "*a*b"));
        //System.out.println(wildcardMatching.isMatch("acdcb", "a*c?b"));
        //System.out.println(wildcardMatching.isMatch("acdscd", "*cd"));
        //System.out.println(wildcardMatching.isMatch("", "*****")); // this is true, * matches empty
        System.out.println(wildcardMatching.isMatch("abcabczzzde", "*abc???de*")); // this is true, matches second abc
    }
}
