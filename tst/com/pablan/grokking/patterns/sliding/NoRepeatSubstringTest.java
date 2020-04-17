package com.pablan.grokking.patterns.sliding;

import org.junit.Test;

public class NoRepeatSubstringTest {

    @Test
    public void test() {
        NoRepeatSubstring noRepeatSubstring = new NoRepeatSubstring();
        System.out.println(noRepeatSubstring.findLength("aabccbb")); // should be 3
        System.out.println(noRepeatSubstring.findLength("abbbb")); // should be 2
        System.out.println(noRepeatSubstring.findLength("abccde")); // should be 3
    }
}
